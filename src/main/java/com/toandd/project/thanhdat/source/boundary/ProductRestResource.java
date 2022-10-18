package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.ProductDTO;
import com.toandd.project.thanhdat.source.model.Product;
import com.toandd.project.thanhdat.source.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin
public class ProductRestResource {
    private final ProductService productService;

    public ProductRestResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("api/v1/products")
    public Object getAll() {
        return ResponseUtils.get(
                productService.findAllDto(ProductDTO.class),
                HttpStatus.OK
        );
    }
    @PostMapping("auth/products")
    public Object save(@RequestBody @Valid ProductDTO dto) {
        return ResponseUtils.get(
          productService.save(dto, Product.class, ProductDTO.class),
          HttpStatus.CREATED
        );

    }
}
