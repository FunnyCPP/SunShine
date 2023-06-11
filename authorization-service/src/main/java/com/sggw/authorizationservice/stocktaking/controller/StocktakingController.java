package com.sggw.authorizationservice.stocktaking.controller;

import com.sggw.authorizationservice.stocktaking.command.CreateStocktakingCommand;
import com.sggw.authorizationservice.stocktaking.dto.CreateStocktakingDTO;
import com.sggw.authorizationservice.stocktaking.query.GetStocktakingViewModelQuery;
import com.sggw.authorizationservice.stocktaking.query.GetStocktakingViewModelsQuery;
import com.sggw.authorizationservice.stocktaking.viewmodel.StocktakingViewModel;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocktaking")
@Hidden
@RequiredArgsConstructor
public class StocktakingController {

    private final CreateStocktakingCommand createStocktakingCommand;
    private final GetStocktakingViewModelQuery getStocktakingViewModelQuery;
    private final GetStocktakingViewModelsQuery getStocktakingViewModelsQuery;

    @GetMapping()
    public ResponseEntity<List<StocktakingViewModel>> getItem() {
        List<StocktakingViewModel> stocktakingViewModel = getStocktakingViewModelsQuery.handle();
        return ResponseEntity.ok(stocktakingViewModel);
    }

    @PostMapping
    public ResponseEntity<Void> createStocktaking(
            @RequestBody CreateStocktakingDTO createStocktakingDTO
    ) {
        createStocktakingCommand.execute(createStocktakingDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StocktakingViewModel> getItem(@PathVariable Integer id) {
        StocktakingViewModel stocktakingViewModel = getStocktakingViewModelQuery.handle(id);
        return ResponseEntity.ok(stocktakingViewModel);
    }
}
