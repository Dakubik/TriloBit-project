package com.warehouse.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String description;
    private int price;
    private String currency = "€";
    private Long stock;
    private Long eanCode;

    public Product(String name, String description, int price, String currency, Long stock, Long eanCode) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.stock = stock;
        this.eanCode = eanCode;
    }
}
