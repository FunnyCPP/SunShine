package com.sggw.authorizationservice.stocktaking.entity;

import com.sggw.authorizationservice.item.entity.Item;
import com.sggw.authorizationservice.stocktaking.StocktakingItemTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocktaking_item")
public class StocktakingItem {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stocktaking_id")
    private Stocktaking stocktaking;

    @Enumerated(EnumType.STRING)
    private StocktakingItemTypeEnum type;
}
