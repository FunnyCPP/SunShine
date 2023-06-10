package com.sggw.authorizationservice.item.command;

import com.sggw.authorizationservice.item.dto.ItemDTO;
import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.ItemsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemCommand {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public void execute(ItemDTO itemDTO){
        this.itemRepository.save(itemMapper.mapItemDTOToEntity(itemDTO));
    }
}
