package com.thecoders.cartunnbackend.returnsList.application.internal.commandservices;

import com.thecoders.cartunnbackend.returnsList.domain.model.aggregates.ReturnList;
import com.thecoders.cartunnbackend.returnsList.domain.model.commands.CreateReturnListCommand;
import com.thecoders.cartunnbackend.returnsList.domain.model.commands.UpdateReturnListCommand;
import com.thecoders.cartunnbackend.returnsList.domain.services.ReturnListCommandService;
import com.thecoders.cartunnbackend.returnsList.infrastructure.persistence.jpa.repositories.ReturnListRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReturnListCommandServiceImpl implements ReturnListCommandService {
    private final ReturnListRepository returnListRepository;

    public ReturnListCommandServiceImpl(ReturnListRepository returnListRepository){
        this.returnListRepository = returnListRepository;
    }

    @Override
    public Long handle(CreateReturnListCommand command) {
        if (returnListRepository.existsByTitle(command.title())) {
            throw new IllegalArgumentException("Return List with title " + command.title() + " already exists");
        }
        var productRefund = new ReturnList(command);
        try {
            returnListRepository.save(productRefund);
            return productRefund.getId();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving return list: " + e.getMessage());
        }
    }


    @Override
    public Optional<ReturnList> handle(UpdateReturnListCommand command){
        if(returnListRepository.existsByTitleAndIdIsNot(command.title(), command.id())){
            throw new IllegalArgumentException("Profile with same return list already exists");
        }
        var result = returnListRepository.findById(command.id());
        if (result.isEmpty()){
            throw new IllegalArgumentException("ProductRefund does not exist");
        }
        var productRefundToUpdated = result.get();
        try {
            productRefundToUpdated.updateInformation(command.title(), command.description(), command.returnDate(), command.status(), command.image());
            var updatedProfile = returnListRepository.save(productRefundToUpdated);
            return Optional.of(updatedProfile);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating return list: " + e.getMessage());
        }
    }
}
