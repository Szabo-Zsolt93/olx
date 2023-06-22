package com.sda.olx.entity;

import com.sda.olx.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String price;
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;
}
