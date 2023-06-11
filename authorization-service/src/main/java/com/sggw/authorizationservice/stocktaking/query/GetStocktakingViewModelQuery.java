package com.sggw.authorizationservice.stocktaking.query;

import com.sggw.authorizationservice.stocktaking.entity.Stocktaking;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingRepository;
import com.sggw.authorizationservice.stocktaking.service.StocktakingMapper;
import com.sggw.authorizationservice.stocktaking.viewmodel.StocktakingViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStocktakingViewModelQuery {

    private final StocktakingRepository stocktakingRepository;
    private final StocktakingMapper stocktakingMapper;
    public StocktakingViewModel handle(Integer stocktakingId) {
        Stocktaking stocktaking = stocktakingRepository.findById(stocktakingId).orElseThrow();
        return stocktakingMapper.mapToViewModel(stocktaking);
    }
}
