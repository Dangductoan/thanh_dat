package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.GroupProductDTO;
import com.toandd.project.thanhdat.source.model.GroupProduct;
import com.toandd.project.thanhdat.source.service.GroupProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin
public class GroupProductRestResource {
   private final GroupProductService groupProductService;

    public GroupProductRestResource(GroupProductService groupProductService) {
        this.groupProductService = groupProductService;
    }

    @GetMapping("api/v1/group-product")
    public Object getAll() {
        return ResponseUtils.get(
                groupProductService.findAllDto(GroupProductDTO.class),
                HttpStatus.OK
        );
    }
    @PostMapping("auth/group-product/create")
    public Object save(@RequestBody @Valid GroupProductDTO dto) {
        return ResponseUtils.get(
          groupProductService.save(dto, GroupProduct.class,GroupProductDTO.class),
          HttpStatus.CREATED
        );
    }
}
