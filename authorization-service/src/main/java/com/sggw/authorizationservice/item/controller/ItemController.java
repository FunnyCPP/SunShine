package com.sggw.authorizationservice.item.controller;

import com.sggw.authorizationservice.item.query.GetItemsQuery;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import com.sggw.authorizationservice.item.viewmodel.ItemsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final GetItemsQuery getItemsQuery;

    @GetMapping
    public ResponseEntity<ItemsResponse> getAllItems() {
        List<ItemViewModel> items = getItemsQuery.handle();
        ItemsResponse itemsResponse =  new ItemsResponse();
        itemsResponse.setItems(items);
        return ResponseEntity.ok(itemsResponse);
    }
}
