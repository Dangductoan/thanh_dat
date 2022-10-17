package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.CustomerDTO;
import com.toandd.project.thanhdat.source.model.Customer;
import com.toandd.project.thanhdat.source.service.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/customers")
@CrossOrigin
public class CustomerRestResource {
    private final CustomerService customerService;

    public CustomerRestResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Object getAllCustomer() {
        return ResponseUtils.get(
                customerService.findAllDto(CustomerDTO.class),
                HttpStatus.OK
        );
    }
    @GetMapping("/paging")
    public Object getAllCustomerPageable(
            @RequestParam("size") int size,
            @RequestParam("index") int index
    ) {
        return ResponseUtils.get(
          customerService.findAllDto(Pageable.ofSize(size).withPage(index), CustomerDTO.class),
          HttpStatus.OK
        );
    }
    @PostMapping
    public Object saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseUtils.get(
          customerService.save(customerDTO, Customer.class, CustomerDTO.class),
          HttpStatus.CREATED
        );
    }
}
