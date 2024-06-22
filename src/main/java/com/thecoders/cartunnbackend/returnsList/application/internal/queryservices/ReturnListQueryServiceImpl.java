package com.thecoders.cartunnbackend.returnsList.application.internal.queryservices;

import com.thecoders.cartunnbackend.returnsList.domain.model.aggregates.ReturnList;
import com.thecoders.cartunnbackend.returnsList.domain.model.queries.GetAllReturnListQuery;
import com.thecoders.cartunnbackend.returnsList.domain.model.queries.GetReturnListByIdQuery;
import com.thecoders.cartunnbackend.returnsList.domain.services.ReturnListQueryService;
import com.thecoders.cartunnbackend.returnsList.infrastructure.persistence.jpa.repositories.ReturnListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnListQueryServiceImpl implements ReturnListQueryService {
    private final ReturnListRepository returnListRepository;

    public ReturnListQueryServiceImpl(ReturnListRepository returnListRepository) {
        this.returnListRepository = returnListRepository;
    }

    @Override
    public Optional<ReturnList> handle(GetReturnListByIdQuery query) {
        return returnListRepository.findById(query.returnListId());
    }

    @Override
    public List<ReturnList> handle(GetAllReturnListQuery query) {
        return returnListRepository.findAll();
    }
}
