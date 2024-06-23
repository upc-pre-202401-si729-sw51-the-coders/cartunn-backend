package com.thecoders.cartunnbackend.productRefunds.domain.model.commands;

public record CreateProductRefundCommand( Long orderId,String title, String description, String status) {

}
