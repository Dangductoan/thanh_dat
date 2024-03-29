package com.toandd.project.thanhdat.source.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import com.toandd.project.thanhdat.common.util.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DynamicUpdate
@Table(name = BaseUtilityClass.Product.TABLE_NAME)
public class Product extends BaseEntity {
    @Length(min = 5, max = 100, message = " name must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Product.NAME)
    private String name;

    @Length(min = 5, max = 10, message = " code must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Product.CODE)
    @Pattern(regexp = Regex.CODE_REGEX, message = "{product.code.regex}")
    private String code;

    @NotBlank
    @Column(name = BaseUtilityClass.Product.DESCRIPTION)
    private String description;

    @Column(name = BaseUtilityClass.Product.BUY_PRICE)
    private Integer buyPrice;

    @Column(name = BaseUtilityClass.Product.FIRST_PRICE)
    private Integer firstPrice;

    @Column(name = BaseUtilityClass.Product.URL_IMAGE)
    @Pattern(regexp = Regex.LINK_REGEX, message = "{product.url.correct}")
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "T_TYPE_PRODUCT_ID", nullable = false)
    private TypeProduct typeProduct;

}
