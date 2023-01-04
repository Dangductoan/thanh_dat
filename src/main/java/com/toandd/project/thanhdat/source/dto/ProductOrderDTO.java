package com.toandd.project.thanhdat.source.dto;

import com.toandd.project.thanhdat.source.model.Order;
import com.toandd.project.thanhdat.source.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductOrderDTO {
    private UUID id;

    private Integer quantity;

    private Integer lastPrice;

    private Product product;

    private Order order;

}
