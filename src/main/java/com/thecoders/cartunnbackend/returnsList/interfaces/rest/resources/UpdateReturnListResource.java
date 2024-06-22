package com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources;

public record UpdateReturnListResource( String title,
                                        String description,
                                        String returnDate,
                                        String status,
                                        String image) {
}
