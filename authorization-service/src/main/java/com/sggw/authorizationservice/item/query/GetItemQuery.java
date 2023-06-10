package com.sggw.authorizationservice.item.query;

import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemQuery {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemViewModel handle(Integer id) {
        return itemMapper.mapItemToViewModel(itemRepository.findById(id).orElseThrow());
    }
}
