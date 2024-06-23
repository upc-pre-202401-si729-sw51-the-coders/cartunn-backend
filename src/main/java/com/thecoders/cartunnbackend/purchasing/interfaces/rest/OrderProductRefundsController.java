package com.thecoders.cartunnbackend.purchasing.interfaces.rest;

import com.thecoders.cartunnbackend.productRefunds.domain.services.ProductRefundQueryService;
import com.thecoders.cartunnbackend.productRefunds.interfaces.rest.resources.ProductRefundResource;
import com.thecoders.cartunnbackend.productRefunds.interfaces.rest.transform.ProductRefundResourceFromEntityAssembler;
import com.thecoders.cartunnbackend.purchasing.domain.model.queries.GetAllProductRefundsByOrderIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/orders/{orderId}/product-refunds", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Product Refunds ")
public class OrderProductRefundsController {
    private final ProductRefundQueryService productRefundQueryService;
    public OrderProductRefundsController(ProductRefundQueryService productRefundQueryService) {
        this.productRefundQueryService = productRefundQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductRefundResource>> getAllProductRefundsByOrderId(@PathVariable Long orderId) {
        var getAllProductRefundsByOrderIdQuery = new GetAllProductRefundsByOrderIdQuery(orderId);
        var productRefunds = productRefundQueryService.handle(getAllProductRefundsByOrderIdQuery);
        var productRefundResources = productRefunds.stream().map(ProductRefundResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(productRefundResources);
    }
}
