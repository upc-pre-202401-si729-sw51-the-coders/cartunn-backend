package com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources;

public record ReturnListResource(Long id,
                                 String title,
                                 String description,
                                 String returnDate,
                                 String status,
                                 String image) {
}
