package com.thecoders.cartunnbackend.returnsList.interfaces.rest.transform;

import com.thecoders.cartunnbackend.returnsList.domain.model.commands.CreateReturnListCommand;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources.CreateReturnListResource;

public class CreateReturnListCommandFromResourceAssembler {
    public static CreateReturnListCommand toCommandFromResource(CreateReturnListResource resource){
        return new CreateReturnListCommand(
                resource.title(),
                resource.description(),
                resource.returnDate(),
                resource.status(),
                resource.image()
        );
    }
}
