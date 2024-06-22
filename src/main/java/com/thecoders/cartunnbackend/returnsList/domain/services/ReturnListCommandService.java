package com.thecoders.cartunnbackend.returnsList.domain.services;

import com.thecoders.cartunnbackend.returnsList.domain.model.aggregates.ReturnList;
import com.thecoders.cartunnbackend.returnsList.domain.model.commands.CreateReturnListCommand;
import com.thecoders.cartunnbackend.returnsList.domain.model.commands.UpdateReturnListCommand;

import java.util.Optional;

public interface ReturnListCommandService {
    Long handle(CreateReturnListCommand command);
    Optional<ReturnList> handle(UpdateReturnListCommand command);
}
