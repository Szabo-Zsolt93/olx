package com.sda.olx.dto;

import lombok.*;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private String category;
    private String price;
    private String image;

}
