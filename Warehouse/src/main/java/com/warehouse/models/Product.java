package com.warehouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private Long price;
    private String currency = "€";
    private Long stock;
    private Long eanCode;
}
