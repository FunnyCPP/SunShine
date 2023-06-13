package com.sggw.authorizationservice.stocktaking.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sggw.authorizationservice.item.viewmodel.ItemViewModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StocktakingViewModel {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("house")
    private String house;

    @JsonProperty("room")
    private String room;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("required_items")
    private List<ItemViewModel> requiredItems;

    @JsonProperty("additional_items")
    private List<ItemViewModel> additionalItems;

    @JsonProperty("missing_items")
    private List<ItemViewModel> missingItems;
}
