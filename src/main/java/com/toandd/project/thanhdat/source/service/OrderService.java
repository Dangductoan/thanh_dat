package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.OrderDTO;
import com.toandd.project.thanhdat.source.model.Order;
import com.toandd.project.thanhdat.source.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface OrderService extends GenericService<Order, OrderDTO, UUID> {

}

@Service
@Transactional
class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final GiraMapper giraMapper;


    OrderServiceImpl(OrderRepository orderRepository, GiraMapper giraMapper) {
        this.orderRepository = orderRepository;
        this.giraMapper = giraMapper;

    }

    @Override
    public JpaRepository<Order, UUID> getRepository() {
        return this.orderRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }

}
