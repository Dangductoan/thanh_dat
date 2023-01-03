package com.toandd.project.thanhdat.source.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toandd.project.thanhdat.common.util.DateTimeUtils;
import com.toandd.project.thanhdat.source.model.BaseUtilityClass;
import com.toandd.project.thanhdat.source.model.Customer;
import com.toandd.project.thanhdat.source.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderDTO {
    private UUID id;

    @Size(min = 5, max = 30, message = "Tên hóa đơn phải có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập tên hóa đơn")
    private String name;

    @Size(min = 3, max = 10, message = "Mã hóa đơn phải có độ dài từ {min} đến {max}")
    @NotNull(message = "Chưa nhập mã hóa đơn")
    private String code;

    @NotBlank
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = DateTimeUtils.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = DateTimeUtils.DATE_TIME_FORMAT)
    private LocalDateTime orderDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = DateTimeUtils.DATE_TIME_FORMAT)
    @DateTimeFormat(pattern = DateTimeUtils.DATE_TIME_FORMAT)
    private LocalDateTime requiredDate;

    @Column(name = BaseUtilityClass.Order.STATUS)
    @Enumerated(EnumType.STRING)
    private Order.Status status = Order.Status.UN_PAID;

    private Integer totalPrice;

    private Customer customer;


}
