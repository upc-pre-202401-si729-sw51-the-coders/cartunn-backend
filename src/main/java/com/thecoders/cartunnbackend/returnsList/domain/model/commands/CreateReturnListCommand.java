package com.thecoders.cartunnbackend.returnsList.domain.model.commands;

public record CreateReturnListCommand(String title, String description,String returnDate,String status, String image) {
}
