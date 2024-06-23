package com.thecoders.cartunnbackend.productRefunds.domain.services;

import com.thecoders.cartunnbackend.productRefunds.domain.model.aggregates.ProductRefund;
import com.thecoders.cartunnbackend.productRefunds.domain.model.queries.GetAllProductRefundsQuery;
import com.thecoders.cartunnbackend.productRefunds.domain.model.queries.GetProductRefundByIdQuery;
import com.thecoders.cartunnbackend.productRefunds.domain.model.queries.GetProductRefundByOrderIdQuery;
import com.thecoders.cartunnbackend.purchasing.domain.model.queries.GetAllProductRefundsByOrderIdQuery;


import java.util.List;
import java.util.Optional;

public interface ProductRefundQueryService {
    Optional<ProductRefund> handle(GetProductRefundByIdQuery query);

    List<ProductRefund> handle(GetAllProductRefundsQuery query);
    List<ProductRefund> handle(GetAllProductRefundsByOrderIdQuery query);
    List<ProductRefund> handle(GetProductRefundByOrderIdQuery query);
}
