package com.sggw.authorizationservice.item.repository;

import com.sggw.authorizationservice.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> getAllByHouseAndRoom(String house, String room);

    Item findItemByCode(String code);
}
