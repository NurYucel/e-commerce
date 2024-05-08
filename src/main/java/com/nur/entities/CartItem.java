package com.nur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CartItems")
public class CartItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private Cart cart;

}
