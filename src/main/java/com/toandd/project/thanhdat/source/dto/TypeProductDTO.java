package com.toandd.project.thanhdat.source.dto;

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
public class TypeProductDTO {
    private UUID id;

    private String name;

    private String code;

    private String description;

    private TypeProduct.GroupProduct groupProduct;
}
