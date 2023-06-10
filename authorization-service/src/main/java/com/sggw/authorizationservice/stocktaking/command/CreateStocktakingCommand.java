package com.sggw.authorizationservice.stocktaking.command;

import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.stocktaking.dto.CreateStocktakingDTO;
import com.sggw.authorizationservice.stocktaking.dto.StocktakingItemDTO;
import com.sggw.authorizationservice.stocktaking.entity.Stocktaking;
import com.sggw.authorizationservice.stocktaking.entity.StocktakingItem;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingItemRepository;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStocktakingCommand {

    private final StocktakingRepository stocktakingRepository;
    private final StocktakingItemRepository stocktakingItemRepository;
    private final ItemRepository itemRepository;

    public void execute(CreateStocktakingDTO createStocktakingDTO) {
        Stocktaking stocktaking = new Stocktaking();
        stocktaking.setHouse(createStocktakingDTO.getHouse());
        stocktaking.setRoom(createStocktakingDTO.getRoom());
        stocktaking.setCreatedAt(createStocktakingDTO.getCreatedAt());
        stocktakingRepository.saveAndFlush(stocktaking);
        for (StocktakingItemDTO stocktakingItemDTO : createStocktakingDTO.getItems()) {
            StocktakingItem stocktakingItem = new StocktakingItem();
            Item item = itemRepository.findById(stocktakingItemDTO.getItemId()).orElseThrow();
            stocktakingItem.setStocktaking(stocktaking);
            stocktakingItem.setItem(item);
            stocktakingItem.setType(stocktakingItemDTO.getType());
            stocktakingItemRepository.save(stocktakingItem);
        }
    }
}
