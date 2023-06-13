package com.sggw.authorizationservice.item.query;

import com.sggw.authorizationservice.item.repository.ItemRepository;
import com.sggw.authorizationservice.item.service.ItemMapper;
import com.sggw.authorizationservice.item.viewmodel.BootstrapViewModel;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import com.sggw.authorizationservice.stocktaking.repository.StocktakingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBootstrapQuery {
    private final ItemRepository itemRepository;
    private final StocktakingRepository stocktakingRepository;

    public BootstrapViewModel handle() {
        BootstrapViewModel bootstrapViewModel = new BootstrapViewModel();
        bootstrapViewModel.setItemsCount(itemRepository.count());
        bootstrapViewModel.setStocktakingCount(stocktakingRepository.count());
        return bootstrapViewModel;
    }
}
