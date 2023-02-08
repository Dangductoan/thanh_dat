package com.toandd.project.thanhdat.source.dto;

import com.toandd.project.thanhdat.common.util.Regex;
import com.toandd.project.thanhdat.source.model.Order;
import com.toandd.project.thanhdat.source.model.TypeProduct;
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
public class ProductDTO {
    private UUID id;

    @NotNull(message = "{product.name.null}")
    private String name;

    @Size(min = 5, max = 10, message = "Mã sản phẩm phải có độ dài từ {min} đến {max}")
    @Pattern(regexp = Regex.CODE_REGEX,message = "{product.code.regex}")
    private String code;

    private String description;

    @Pattern(regexp = Regex.LINK_REGEX,message = "{product.url.correct}")
    private String urlImage;

    @NotNull(message = "Chưa nhập giá mua")
    private Integer buyPrice;

    @NotNull(message = "Chưa nhập giá bán")
    private Integer firstPrice;

    private TypeProduct typeProduct;
}
