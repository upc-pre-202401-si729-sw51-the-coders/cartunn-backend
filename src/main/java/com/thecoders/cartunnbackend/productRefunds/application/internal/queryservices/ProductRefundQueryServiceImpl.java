package com.thecoders.cartunnbackend.productRefunds.application.internal.queryservices;

import com.thecoders.cartunnbackend.productRefunds.domain.model.aggregates.ProductRefund;
import com.thecoders.cartunnbackend.productRefunds.domain.model.queries.GetAllProductRefundsQuery;
import com.thecoders.cartunnbackend.productRefunds.domain.model.queries.GetProductRefundByIdQuery;
import com.thecoders.cartunnbackend.productRefunds.domain.model.queries.GetProductRefundByOrderIdQuery;
import com.thecoders.cartunnbackend.productRefunds.domain.services.ProductRefundQueryService;
import com.thecoders.cartunnbackend.productRefunds.infrastructure.jpa.persistence.ProductRefundRepository;
import com.thecoders.cartunnbackend.purchasing.domain.model.queries.GetAllProductRefundsByOrderIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRefundQueryServiceImpl implements ProductRefundQueryService {
    private final ProductRefundRepository productRefundRepository;

    public ProductRefundQueryServiceImpl(ProductRefundRepository productRefundRepository) {
        this.productRefundRepository = productRefundRepository;
    }

    @Override
    public Optional<ProductRefund> handle(GetProductRefundByIdQuery query) {
        return productRefundRepository.findById(query.ProductRefundId());
    }
    @Override
    public List<ProductRefund> handle(GetAllProductRefundsQuery query) {
        return productRefundRepository.findAll();
    }

    public List<ProductRefund> handle(GetAllProductRefundsByOrderIdQuery query) {
        return productRefundRepository.findAllByOrderId(query.orderId());
    }
    public List<ProductRefund> handle(GetProductRefundByOrderIdQuery query) {
        return productRefundRepository.findByOrderId(query.orderId());
    }
}
