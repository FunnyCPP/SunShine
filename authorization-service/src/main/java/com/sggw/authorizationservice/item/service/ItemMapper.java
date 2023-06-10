package com.sggw.authorizationservice.item.service;


import com.sggw.authorizationservice.item.dto.ItemDTO;
import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMapper {

    public ItemViewModel mapItemToViewModel(Item item){
        ItemViewModel itemViewModel = new ItemViewModel();
        itemViewModel.setId(item.getId());
        itemViewModel.setTitle(item.getTitle());
        itemViewModel.setRoom(item.getRoom());
        itemViewModel.setHouse(item.getHouse());
        itemViewModel.setDescription(item.getDescription());
        itemViewModel.setPurchasingDate(item.getPurchasingDate());
        itemViewModel.setScrappingDate(item.getScrappingDate());

        return itemViewModel;
    }

    public Item mapItemDTOToEntity(ItemDTO itemDTO) {
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
