package com.sggw.authorizationservice.stocktaking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocktaking")
public class Stocktaking {

    @Id
    @GeneratedValue
    private Integer id;

    private String room;

    private String house;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public Stocktaking setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getRoom() {
        return room;
    }

    public Stocktaking setRoom(String room) {
        this.room = room;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public Stocktaking setHouse(String house) {
        this.house = house;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Stocktaking setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
