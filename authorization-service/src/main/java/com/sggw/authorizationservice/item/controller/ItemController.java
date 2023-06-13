package com.sggw.authorizationservice.item.controller;

import com.sggw.authorizationservice.item.command.CreateItemCommand;
import com.sggw.authorizationservice.item.dto.ItemDTO;
import com.sggw.authorizationservice.item.query.*;
import com.sggw.authorizationservice.item.viewmodel.BootstrapViewModel;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import com.sggw.authorizationservice.item.viewmodel.ItemsResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@Hidden
@RequiredArgsConstructor
public class ItemController {

    private final GetItemsQuery getItemsQuery;
    private final GetItemsByHouseAndRoom getItemsByHouseAndRoom;
    private final GetItemQuery getItemQuery;
    private final GetItemByCodeQuery getItemByCodeQuery;
    private final CreateItemCommand createItemCommand;
    private final GetBootstrapQuery getBootstrapQuery;

    @GetMapping
    public ResponseEntity<ItemsResponse> getItems(
            @RequestParam(name = "house", required = false) String house,
            @RequestParam(name = "room", required = false) String room
    ) {
        List<ItemViewModel> items;
        if(house == null && room == null) {
            items = getItemsQuery.handle();
        } else  {
            items = getItemsByHouseAndRoom.handle(house,room);
        }

        ItemsResponse itemsResponse =  new ItemsResponse();
        itemsResponse.setItems(items);
        return ResponseEntity.ok(itemsResponse);
    }

    @PostMapping
    public ResponseEntity<Void> createItem(
            @RequestBody ItemDTO itemDTO
    ) {
        createItemCommand.execute(itemDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemViewModel> getItem(@PathVariable Integer id) {
        ItemViewModel item = getItemQuery.handle(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ItemViewModel> getItemByCode(@PathVariable String code) {
        ItemViewModel item = getItemByCodeQuery.handle(code);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/bootstrap}")
    public ResponseEntity<BootstrapViewModel> getItem() {
        return ResponseEntity.ok(getBootstrapQuery.handle());
    }
}
