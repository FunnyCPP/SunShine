package com.sggw.authorizationservice.item.command;

import com.sggw.authorizationservice.item.dto.ItemDTO;
import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.viewmodel.ItemsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemCommand {

    private final ItemRepository itemRepository;

    public void execute(ItemDTO itemDTO){
        this.
        itemRepository.save(mapItemDTOToEntity(itemDTO));
    }

    private Item mapItemDTOToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setTitle(itemDTO.getTitle());
        item.setRoom(itemDTO.getRoom());
        item.setHouse(itemDTO.getHouse());
        item.setDescription(itemDTO.getDescription());
        item.setPurchasingDate(itemDTO.getPurchasingDate());
        item.setScrappingDate(itemDTO.getScrappingDate());
        return item;
    }
}
