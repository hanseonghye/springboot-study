package com.springboot.paging.controller;

import com.springboot.paging.model.Restaurant;
import com.springboot.paging.model.RestaurantModel;
import com.springboot.paging.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;


    @GetMapping
    public ResponseEntity getRestaurants(@PageableDefault Pageable pageable, PagedResourcesAssembler<Restaurant> assembler) {
        Page<Restaurant> restaurants = restaurantService.getRestaurants(pageable);
        PagedModel<RestaurantModel> pagedModel = assembler.toModel(restaurants, e -> new RestaurantModel(e));
        return ResponseEntity.ok().body(pagedModel);
    }

    @GetMapping("/2")
    public ResponseEntity getRestaurants2(@PageableDefault Pageable pageable) {
        Page<Restaurant> restaurants = restaurantService.getRestaurants(pageable);
        return ResponseEntity.ok().body(restaurants);
    }
}
