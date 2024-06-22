package com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources;

public record CreateReturnListResource(String title,
                                       String description,
                                       String returnDate,
                                       String status,
                                       String image)
{
}
