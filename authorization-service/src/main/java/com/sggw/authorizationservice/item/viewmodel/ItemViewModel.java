package com.sggw.authorizationservice.item.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemViewModel {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("room")
    private String room;

    @JsonProperty("house")
    private String house;

    @JsonProperty("description")
    private String description;

    @JsonProperty("purchasing_date")
    private Date purchasingDate;

    @JsonProperty("scrapping_date")
    private Date scrappingDate;

    @JsonProperty("code")
    private String code;
}
