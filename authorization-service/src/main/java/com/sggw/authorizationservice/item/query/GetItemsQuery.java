package com.sggw.authorizationservice.item.query;

import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetItemsQuery {

    private final ItemRepository itemRepository;

    public List<ItemViewModel> handle() {
        return itemRepository.findAll().stream().map(this::mapItemToViewModel).toList();
    }

    private ItemViewModel  mapItemToViewModel(Item item){
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
}
