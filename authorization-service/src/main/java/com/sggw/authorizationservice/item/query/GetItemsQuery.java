package com.sggw.authorizationservice.item.query;

import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetItemsQuery {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemViewModel> handle() {
        return itemRepository.findAll().stream().map(itemMapper::mapItemToViewModel).toList();
    }


}
