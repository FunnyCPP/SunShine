package com.sggw.authorizationservice.stocktaking.service;

import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import com.sggw.authorizationservice.stocktaking.StocktakingItemTypeEnum;
import com.sggw.authorizationservice.stocktaking.entity.Stocktaking;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingItemRepository;
import com.sggw.authorizationservice.stocktaking.viewmodel.StocktakingViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StocktakingMapper {

    private final StocktakingItemRepository stocktakingItemRepository;
    private final ItemMapper itemMapper;

    public StocktakingViewModel mapToViewModel(Stocktaking stocktaking) {
        StocktakingViewModel stocktakingViewModel = new StocktakingViewModel();

        stocktakingViewModel.setId(stocktaking.getId());
        stocktakingViewModel.setHouse(stocktaking.getHouse());
        stocktakingViewModel.setRoom(stocktaking.getRoom());
        stocktakingViewModel.setCreatedAt(stocktaking.getCreatedAt());

        List<ItemViewModel> requiredItems = stocktakingItemRepository
                .getStocktakingItemsByStocktakingAndType(stocktaking, StocktakingItemTypeEnum.REQUIRED_ITEM)
                .stream()
                .map(stocktakingItem -> itemMapper.mapItemToViewModel(stocktakingItem.getItem()))
                .toList();

        List<ItemViewModel> additionalItems = stocktakingItemRepository
                .getStocktakingItemsByStocktakingAndType(stocktaking, StocktakingItemTypeEnum.ADDITIONAL_ITEM)
                .stream()
                .map(stocktakingItem -> itemMapper.mapItemToViewModel(stocktakingItem.getItem()))
                .toList();

        List<ItemViewModel> missingItems = stocktakingItemRepository
                .getStocktakingItemsByStocktakingAndType(stocktaking, StocktakingItemTypeEnum.MISSING_ITEM)
                .stream()
                .map(stocktakingItem -> itemMapper.mapItemToViewModel(stocktakingItem.getItem()))
                .toList();

        stocktakingViewModel.setRequiredItems(requiredItems);
        stocktakingViewModel.setAdditionalItems(additionalItems);
        stocktakingViewModel.setMissingItems(missingItems);

        return stocktakingViewModel;
    }
}
