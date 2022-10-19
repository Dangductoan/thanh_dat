package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.ProductOrderDTO;
import com.toandd.project.thanhdat.source.model.ProductOrder;
import com.toandd.project.thanhdat.source.service.ProductOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/product-order")
@CrossOrigin
public class ProductOrderRestResource {
    private final ProductOrderService productOrderService;

    public ProductOrderRestResource(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public Object getAll() {
        return ResponseUtils.get(
                productOrderService.findAllDto(ProductOrderDTO.class),
                HttpStatus.OK
        );
    }
    @PostMapping("/create")
    public Object save(@RequestBody @Valid ProductOrderDTO dto) {
        return ResponseUtils.get(
          productOrderService.save(dto, ProductOrder.class, ProductOrderDTO.class),
          HttpStatus.CREATED
        );
    }
}
