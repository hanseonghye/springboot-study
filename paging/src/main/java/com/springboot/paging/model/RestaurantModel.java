package com.springboot.paging.model;

import com.springboot.paging.controller.RestaurantController;
import lombok.Getter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.core.Relation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Getter
@Relation(collectionRelation = "restaurant")
public class RestaurantModel extends EntityModel<Restaurant> {
    public RestaurantModel(Restaurant restaurant, Link... links) {
        super(restaurant, links);
        add(linkTo(RestaurantController.class).slash(restaurant.getRestaurantId()).withSelfRel());
    }
}