package com.toandd.project.thanhdat.source.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = BaseUtilityClass.Customer.TABLE_NAME)
public class Customer extends BaseEntity   {


    @Length(min = 5,max = 100,message = " name must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Customer.NAME)
    private String name;

    @Length(min = 5,max = 10,message = " phone must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Customer.PHONE)
    private String phone;

    @Length(min = 5,max = 10,message = " code must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Customer.CODE)
    private String code;

    @Length(min = 5,max = 50)
    @Column(name = BaseUtilityClass.Customer.ADDRESS)
    private String address;

    @Length(min = 1,max = 10)
    @Column(name = BaseUtilityClass.Customer.COUNTRY)
    private String country = "VIET NAM";


}
