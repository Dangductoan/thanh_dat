package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.ProductDTO;
import com.toandd.project.thanhdat.source.model.Product;
import com.toandd.project.thanhdat.source.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

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
    @GetMapping("api/v1/products/{id}")
    public Object getById(@RequestParam UUID id) {
        return ResponseUtils.get(
                productService.findById(id,ProductDTO.class),
                HttpStatus.OK
        );
    }

    @PostMapping("auth/products/create")
    public Object save(@RequestBody @Valid ProductDTO dto) {
        return ResponseUtils.get(
                productService.save(dto, Product.class, ProductDTO.class),
                HttpStatus.CREATED
        );

    }
    @PutMapping("auth/products/update")
    public Object update(@RequestBody @Valid ProductDTO dto) {
        return ResponseUtils.get(
                productService.update(dto,ProductDTO.class),
                HttpStatus.OK
        );
    }
//    @DeleteMapping
//    public Object delete() {
//        return ResponseUtils.get(
//                productService.delete(dto,Product.class,ProductDTO.class),
//                HttpStatus.OK
//        );
//    }
}
