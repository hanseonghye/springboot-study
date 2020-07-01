package com.springboot.paging.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Restaurant {
    @Id @GeneratedValue
    private Integer restaurantId;

    private String name;

    private Integer mapx;

    private Integer mapy;

    private String roadAddress;
}
