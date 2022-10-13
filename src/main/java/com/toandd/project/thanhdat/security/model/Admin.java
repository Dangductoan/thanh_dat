package com.toandd.project.thanhdat.security.model;

import com.toandd.project.thanhdat.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name = "T_ADMIN")
public class Admin extends BaseEntity {
    @Column(name = "T_USERNAME",
            nullable = false,
            updatable = false,
            unique = true,
            length = 100)
    private String username;

    @Column(name = "T_PASSWORD",
            nullable = false,
            updatable = false,
            unique = true,
            length = 100)
    private String password;
}
