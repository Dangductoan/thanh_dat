package com.toandd.project.thanhdat.source.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = BaseUtilityClass.TypeProduct.TABLE_NAME)
public class TypeProduct extends BaseEntity {
    @Length(min = 5, max = 100, message = " name must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.TypeProduct.NAME)
    private String name;

    @Length(min = 5, max = 10, message = " code must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.TypeProduct.CODE)
    private String code;

    @NotBlank
    @Column(name = BaseUtilityClass.TypeProduct.DESCRIPTION)
    private String description;

    @Column(name = BaseUtilityClass.TypeProduct.GROUP_PRODUCT)
    @Enumerated(EnumType.STRING)
    private GroupProduct groupProduct;

    public enum GroupProduct {
        TRANH_DONG,
        DO_THO,
        DO_DONG_PHONG_THUY,
        CHUONG_TRONG,
        SAN_PHAM_DAT_VANG
    }
}

