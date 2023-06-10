package com.sggw.authorizationservice.stocktaking.repository;

import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.stocktaking.StocktakingItemTypeEnum;
import com.sggw.authorizationservice.stocktaking.entity.Stocktaking;
import com.sggw.authorizationservice.stocktaking.entity.StocktakingItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StocktakingItemRepository  extends JpaRepository<StocktakingItem, Integer> {

    public List<StocktakingItem> getStocktakingItemsByStocktakingAndType(Stocktaking stocktaking, StocktakingItemTypeEnum type);
}
