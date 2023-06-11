package com.sggw.authorizationservice.stocktaking.query;

import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import com.sggw.authorizationservice.stocktaking.StocktakingItemTypeEnum;
import com.sggw.authorizationservice.stocktaking.entity.Stocktaking;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingItemRepository;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingRepository;
import com.sggw.authorizationservice.stocktaking.service.StocktakingMapper;
import com.sggw.authorizationservice.stocktaking.viewmodel.StocktakingViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStocktakingViewModelsQuery {
    private final StocktakingRepository stocktakingRepository;
    private final StocktakingMapper stocktakingMapper;

    public List<StocktakingViewModel> handle() {
      List<Stocktaking> stocktaking = stocktakingRepository.findAll();
      List<StocktakingViewModel> stocktakingViewModels = stocktaking.stream().map(stocktakingMapper::mapToViewModel).toList();

        return stocktakingViewModels;
    }
}
