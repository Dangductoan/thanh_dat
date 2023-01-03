package com.toandd.project.thanhdat.source.dto;

import com.toandd.project.thanhdat.source.model.Order;
import com.toandd.project.thanhdat.source.model.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductDTO {
    private UUID id;

    private String name;

    private String code;

    private String description;

    private String urlImage;

    private Integer buyPrice;

    private Integer firstPrice;

    private Order.Status status;

    private TypeProduct typeProduct;
}
