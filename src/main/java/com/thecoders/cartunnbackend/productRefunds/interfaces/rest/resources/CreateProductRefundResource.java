package com.thecoders.cartunnbackend.productRefunds.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record CreateProductRefundResource(
        @NotNull Long orderId,
        String title,
        String description,
        String status){
}
