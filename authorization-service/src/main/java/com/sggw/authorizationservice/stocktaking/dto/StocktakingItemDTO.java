package com.sggw.authorizationservice.stocktaking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sggw.authorizationservice.stocktaking.StocktakingItemTypeEnum;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StocktakingItemDTO {

    @JsonProperty("type")
    private StocktakingItemTypeEnum type;

    @JsonProperty("item_id")
    private Integer itemId;

}
