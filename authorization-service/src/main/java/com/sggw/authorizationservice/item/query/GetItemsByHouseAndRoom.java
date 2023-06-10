package com.sggw.authorizationservice.item.query;

import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetItemsByHouseAndRoom {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemViewModel> handle(String house, String room) {
        return itemRepository.getAllByHouseAndRoom(house,room).stream().map(itemMapper::mapItemToViewModel).toList();
    }
}
