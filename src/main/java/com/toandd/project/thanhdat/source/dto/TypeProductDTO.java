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
public class TypeProductDTO {
    private UUID id;
    @Size(min = 5, max = 30, message = "Tên loaị sản phẩm có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên khách hàng")
    private String name;
    @Size(min = 5, max = 30, message = "Mã loại sản phẩm có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên khách hàng")
    private String code;
    @NotBlank
    private String description;
}
