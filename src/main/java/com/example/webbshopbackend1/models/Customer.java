package com.example.webbshopbackend1.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int ssn;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    private Date created;
    private Date updated;

    public Customer(String name, String ssn) {
    }

    public Customer(Long id) {
        this.id = id;
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

