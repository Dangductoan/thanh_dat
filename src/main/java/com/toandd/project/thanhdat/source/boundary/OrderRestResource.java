package com.toandd.project.thanhdat.source.boundary;

import com.toandd.project.thanhdat.common.util.ResponseUtils;
import com.toandd.project.thanhdat.source.dto.OrderDTO;
import com.toandd.project.thanhdat.source.model.Order;
import com.toandd.project.thanhdat.source.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/orders")
@CrossOrigin
public class OrderRestResource {
    private final OrderService orderService;

    public OrderRestResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public Object getAll() {
        return ResponseUtils.get(
                orderService.findAllDto(OrderDTO.class),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public Object save(@RequestBody @Valid OrderDTO dto) {
        return ResponseUtils.get(
                orderService.save(dto, Order.class, OrderDTO.class),
                HttpStatus.CREATED

        );
    }

}
