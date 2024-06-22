package com.thecoders.cartunnbackend.returnsList.interfaces.rest.transform;

import com.thecoders.cartunnbackend.returnsList.domain.model.commands.UpdateReturnListCommand;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources.UpdateReturnListResource;

public class UpdateReturnListCommandFromResourceAssembler {
    public static UpdateReturnListCommand toCommandFromResource(Long returnListId, UpdateReturnListResource resource){
        return new UpdateReturnListCommand(returnListId, resource.title(), resource.description(), resource.returnDate(), resource.status(), resource.image());

    }
}
