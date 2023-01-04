package com.toandd.project.thanhdat.source.dto;

import com.toandd.project.thanhdat.common.util.Regex;
import com.toandd.project.thanhdat.source.model.TypeProduct;
import com.toandd.project.thanhdat.source.validation.anotation.UniqueTypeProductCode;
import com.toandd.project.thanhdat.source.validation.anotation.UniqueTypeProductName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TypeProductDTO {
    private UUID id;

    @Length(min = 5, max = 100, message = "name must have length between {min} and {max}")
    @UniqueTypeProductName
    private String name;

    @Length(min = 5, max = 10, message = "code must have length between {min} and {max}")
    @Pattern(regexp = Regex.CODE_REGEX,message = "{type.code.regex}")
    @UniqueTypeProductCode
    private String code;

    private String description;

    private TypeProduct.GroupProduct groupProduct;
}
