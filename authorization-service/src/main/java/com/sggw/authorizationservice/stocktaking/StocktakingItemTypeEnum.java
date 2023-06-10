package com.sggw.authorizationservice.stocktaking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum StocktakingItemTypeEnum {
    @JsonProperty("required_item")
    REQUIRED_ITEM,
    @JsonProperty("missing_item")
    MISSING_ITEM,
    @JsonProperty("additional_item")
    ADDITIONAL_ITEM,
}
