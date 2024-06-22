package com.thecoders.cartunnbackend.returnsList.interfaces.rest;


import com.thecoders.cartunnbackend.returnsList.domain.model.queries.GetAllReturnListQuery;
import com.thecoders.cartunnbackend.returnsList.domain.model.queries.GetReturnListByIdQuery;
import com.thecoders.cartunnbackend.returnsList.domain.services.ReturnListCommandService;
import com.thecoders.cartunnbackend.returnsList.domain.services.ReturnListQueryService;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources.CreateReturnListResource;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources.ReturnListResource;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.resources.UpdateReturnListResource;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.transform.CreateReturnListCommandFromResourceAssembler;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.transform.ReturnListResourceFromEntityAssembler;
import com.thecoders.cartunnbackend.returnsList.interfaces.rest.transform.UpdateReturnListCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/return-list", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Return List ", description = "Return List Management Endpoints")

public class ReturnListController {
    private final ReturnListCommandService returnListCommandService;
    private final ReturnListQueryService returnListQueryService;

    public ReturnListController(ReturnListCommandService returnListCommandService, ReturnListQueryService returnListQueryService) {
        this.returnListCommandService = returnListCommandService;
        this.returnListQueryService = returnListQueryService;
    }


    @PostMapping
    public ResponseEntity<ReturnListResource> createProductRefund(@RequestBody CreateReturnListResource createReturnListResource) {
        var createReturnListCommand = CreateReturnListCommandFromResourceAssembler.toCommandFromResource(createReturnListResource);
        var returnListId = returnListCommandService.handle(createReturnListCommand);
        if (returnListId == 0L) return ResponseEntity.badRequest().build();

        var getProductRefundByIdQuery = new GetReturnListByIdQuery(returnListId);
        var returnList = returnListQueryService.handle(getProductRefundByIdQuery);
        if(returnList.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var returnListResource = ReturnListResourceFromEntityAssembler.toResourceFromEntity(returnList.get());
        return new ResponseEntity<>(returnListResource, HttpStatus.CREATED);
    }

    @GetMapping("/{returnListId}")
    public ResponseEntity<ReturnListResource> getReturnList(@PathVariable Long returnListId){
        var getReturnListByIdQuery = new GetReturnListByIdQuery(returnListId);
        var returnList = returnListQueryService.handle(getReturnListByIdQuery);
        if(returnList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var returnListResource = ReturnListResourceFromEntityAssembler.toResourceFromEntity(returnList.get());
        return ResponseEntity.ok(returnListResource);
    }

    @GetMapping
    public ResponseEntity<List<ReturnListResource>> getAllReturnLists(){
        var getAllProductRefundsQuery = new GetAllReturnListQuery();
        var returnList = returnListQueryService.handle(getAllProductRefundsQuery);
        var returnListsResources = returnList.stream().map(ReturnListResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(returnListsResources);
    }

    @PutMapping("/{returnListId}")
    public ResponseEntity<ReturnListResource> updateReturnList(@PathVariable Long returnListId, @RequestBody UpdateReturnListResource updateReturnListResource){
        var updateReturnListCommand = UpdateReturnListCommandFromResourceAssembler.toCommandFromResource(returnListId, updateReturnListResource);
        var updateReturnList = returnListCommandService.handle(updateReturnListCommand);
        if (updateReturnList.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var returnListResource = ReturnListResourceFromEntityAssembler.toResourceFromEntity(updateReturnList.get());
        return ResponseEntity.ok(returnListResource);
    }
}
