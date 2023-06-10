package com.sggw.authorizationservice.stocktaking.repository;

import com.sggw.authorizationservice.stocktaking.entity.Stocktaking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocktakingRepository extends JpaRepository<Stocktaking, Integer> {
}
