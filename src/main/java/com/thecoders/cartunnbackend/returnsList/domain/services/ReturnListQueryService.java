package com.thecoders.cartunnbackend.returnsList.domain.services;

import com.thecoders.cartunnbackend.productRefunds.domain.model.aggregates.ProductRefund;
import com.thecoders.cartunnbackend.returnsList.domain.model.aggregates.ReturnList;
import com.thecoders.cartunnbackend.returnsList.domain.model.queries.GetAllReturnListQuery;
import com.thecoders.cartunnbackend.returnsList.domain.model.queries.GetReturnListByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReturnListQueryService {
    Optional<ReturnList> handle(GetReturnListByIdQuery query);
    List<ReturnList> handle(GetAllReturnListQuery query);
}
