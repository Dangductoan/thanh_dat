package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.TypeProductDTO;
import com.toandd.project.thanhdat.source.model.TypeProduct;
import com.toandd.project.thanhdat.source.service.TypeProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin
public class TypeProductRestResource {
    private final TypeProductService typeProductService;

    public TypeProductRestResource(TypeProductService typeProductService) {
        this.typeProductService = typeProductService;
    }

    @GetMapping("api/v1/type-product")
    public Object getAll() {
        return ResponseUtils.get(
          typeProductService.findAllDto(TypeProductDTO.class),
          HttpStatus.OK
        );
    }
    @PostMapping("auth/type-product/create")
    public Object save(@RequestBody @Valid TypeProductDTO dto) {
        return ResponseUtils.get(
          typeProductService.save(dto, TypeProduct.class, TypeProductDTO.class),
          HttpStatus.CREATED
        );
    }
}
