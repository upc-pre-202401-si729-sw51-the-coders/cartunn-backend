package com.thecoders.cartunnbackend.returnsList.domain.model.commands;

public record UpdateReturnListCommand(Long id,String title, String description,String returnDate,String status, String image) {
}
