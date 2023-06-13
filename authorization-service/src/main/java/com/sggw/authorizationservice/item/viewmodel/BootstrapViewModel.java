package com.sggw.authorizationservice.item.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BootstrapViewModel {
    @JsonProperty("items_count")
    private Long itemsCount;

    @JsonProperty("stocktaking_count")
    private Long stocktakingCount;
}
