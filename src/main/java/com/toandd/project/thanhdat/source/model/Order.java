package com.toandd.project.thanhdat.source.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toandd.project.thanhdat.common.model.BaseEntity;
import com.toandd.project.thanhdat.common.util.DateTimeUtils;
import com.toandd.project.thanhdat.common.util.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DynamicUpdate
@Table(name = BaseUtilityClass.Order.TABLE_NAME)
public class Order extends BaseEntity {
    @Column(name = BaseUtilityClass.Order.NAME)
    @Length(min = 5, max = 100, message = " name must have length between {min} and {max}")
    private String name;

    @NotBlank
    @Column(name = BaseUtilityClass.Order.DESCRIPTION)
    private String description;

    @Length(min = 3, max = 10, message = " code must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Order.CODE)
    @Pattern(regexp = Regex.CODE_REGEX,message = "{order.code.regex}")
    private String code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = DateTimeUtils.DATE_TIME_FORMAT)
    @Column(name = BaseUtilityClass.Order.ORDER_DATE)
    private LocalDateTime orderDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = DateTimeUtils.DATE_TIME_FORMAT)
    @Column(name = BaseUtilityClass.Order.REQUIRED_DATE)
    private LocalDateTime requiredDate;

    @Column(name = BaseUtilityClass.Order.STATUS)
    @Enumerated(EnumType.STRING)
    private Status status = Status.UN_PAID;

    @Column(name = BaseUtilityClass.Order.TOTAL_ORDER)
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "T_CUSTOMER_ID", nullable = false)
    private Customer customer;


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj))
            return false;
        Order order = (Order) obj;
        return this.id != null && Objects.equals(this.id, order.id);
    }

    public enum Status {
        PAID,
        UN_PAID,
        IN_DEBT
    }


}


