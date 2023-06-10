package com.sggw.authorizationservice.stocktaking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CreateStocktakingDTO {

    @JsonProperty("house")
    private String house;

    @JsonProperty("room")
    private String room;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("items")
    private List<StocktakingItemDTO> items;
}
