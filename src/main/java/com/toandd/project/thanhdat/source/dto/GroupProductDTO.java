package com.toandd.project.thanhdat.source.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GroupProductDTO {
    private UUID id;
    @Size(min = 5, max = 30, message = "Tên khách hàng phải có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên nhóm sản phẩm")
    private String name;
    @Size(min = 5, max = 10, message = "Mã nhóm sản phẩm phải có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên mã nhóm sản phẩm")
    private String code;
    @NotBlank
    private String description;
}
