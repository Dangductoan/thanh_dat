package com.toandd.project.thanhdat.source.dto;

import com.toandd.project.thanhdat.common.util.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CustomerDTO {

    private UUID id;

    @Size(min = 5, max = 30, message = "name must have length between {min} and {max}")
    private String name;

    @NotNull(message = "{customer.phone.null}")
    @Pattern(regexp = Regex.VIETNAM_PHONE_REGEX,message = "{customer.phone.regex}")
    private String phone;

    @Size(min = 5, max = 10, message = "code must have length between {min} and {max}")
    @Pattern(regexp = Regex.CODE_REGEX,message = "{customer.code.regex}")
    private String code;

    @NotNull(message = "{customer.address.null}")
    private String address;

    private String description;
}
