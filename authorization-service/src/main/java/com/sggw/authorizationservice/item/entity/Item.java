package com.sggw.authorizationservice.item.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String room;

    private String house;

    private String description;

    private Date purchasingDate;

    private Date scrappingDate;

    private String code;

    public Integer getId() {
        return id;
    }

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getRoom() {
        return room;
    }

    public Item setRoom(String room) {
        this.room = room;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public Item setHouse(String house) {
        this.house = house;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getPurchasingDate() {
        return purchasingDate;
    }

    public Item setPurchasingDate(Date purchasingDate) {
        this.purchasingDate = purchasingDate;
        return this;
    }

    public Date getScrappingDate() {
        return scrappingDate;
    }

    public Item setScrappingDate(Date scrappingDate) {
        this.scrappingDate = scrappingDate;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Item setCode(String code) {
        this.code = code;
        return this;
    }
}
