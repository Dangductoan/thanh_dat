package com.toandd.project.thanhdat.source.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CustomerDTO {

    private UUID id;

    @Size(min = 5, max = 30, message = "Tên khách hàng phải có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên khách hàng")
    private String name;

    @NotNull(message = "Chưa nhập số điện thoại")
    private String phone;

    @Size(min = 5, max = 10, message = "Mã khách hàng phải có độ dài từ {min} đến {max}")
    private String code;

    @NotNull(message = "Chưa nhập địa chỉ")
    private String address;

    private String description;
}
