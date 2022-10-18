package com.toandd.project.thanhdat.source.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name=BaseUtilityClass.ProductOrder.TABLE_NAME)
public class ProductOrder extends BaseEntity {
    @Column(name = BaseUtilityClass.ProductOrder.QUANTITY)
    private Integer quantity;
    @Column(name = BaseUtilityClass.ProductOrder.SELF_PRICE)
    private Integer selfPrice;
    @OneToOne
    private Product product;
    @ManyToMany(mappedBy = BaseUtilityClass.OrderMappedProductOrder.PRODUCT_ORDER_MAPPED_ORDER)
    private Set<Order> orders = new LinkedHashSet<>();
}
