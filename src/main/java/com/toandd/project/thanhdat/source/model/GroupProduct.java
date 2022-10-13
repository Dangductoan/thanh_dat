package com.toandd.project.thanhdat.source.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name=BaseUtilityClass.GroupProduct.TABLE_NAME)
public class GroupProduct extends BaseEntity {
    @Length(min = 5,max = 100,message = " name must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.GroupProduct.NAME)
    private String name;
    @Length(min = 5,max = 10,message = " code must have length between {min} and {max}")
    @Column(name = BaseUtilityClass.GroupProduct.CODE)
    private String code;
    @NotBlank
    @Column(name = BaseUtilityClass.GroupProduct.DESCRIPTION)
    private String description;

}
