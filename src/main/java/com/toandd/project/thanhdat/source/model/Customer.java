package com.toandd.project.thanhdat.source.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import com.toandd.project.thanhdat.common.util.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = BaseUtilityClass.Customer.TABLE_NAME)
public class Customer extends BaseEntity {


    @Length(min = 5, max = 100, message = " name must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Customer.NAME)
    private String name;

    @Column(name = BaseUtilityClass.Customer.PHONE)
    @Pattern(regexp = Regex.VIETNAM_PHONE_REGEX,message = "{customer.phone.regex}")
    private String phone;

    @Length(min = 5, max = 10, message = " code must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.Customer.CODE)
    @Pattern(regexp = Regex.CODE_REGEX,message = "{customer.code.regex}")
    private String code;

    @Length(min = 5, max = 50)
    @Column(name = BaseUtilityClass.Customer.ADDRESS)
    private String address;

    @Length(min = 1, max = 10)
    @Column(name = BaseUtilityClass.Customer.COUNTRY)
    private String country = "VIET NAM";

    @Column(name = BaseUtilityClass.Customer.DESCRIPTION)
    private String description;

}
