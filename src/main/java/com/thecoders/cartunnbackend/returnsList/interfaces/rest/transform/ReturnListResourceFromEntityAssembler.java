package com.thecoders.cartunnbackend.returnsList.interfaces.rest.transform;

import com.thecoders.cartunnbackend.returnsList.domain.model.aggregates.ReturnList;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources.ReturnListResource;

public class ReturnListResourceFromEntityAssembler {
    public static ReturnListResource toResourceFromEntity(ReturnList entity){
        return new ReturnListResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getReturnDate(),
                entity.getStatus(),
                entity.getImage()
        );
    }
}
