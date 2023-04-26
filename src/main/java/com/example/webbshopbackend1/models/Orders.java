package com.example.webbshopbackend1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Orders {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersProduct> ordersProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Customer customer;

    private Date created;
    private Date updated;

    public Orders(List<OrdersProduct> ordersProducts, Customer customer) {
        this.ordersProducts = ordersProducts;
        this.customer = customer;
    }

    public void setOrdersProducts(List<OrdersProduct> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
