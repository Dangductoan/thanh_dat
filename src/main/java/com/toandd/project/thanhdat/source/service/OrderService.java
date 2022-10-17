package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.source.dto.OrderDTO;
import com.toandd.project.thanhdat.source.model.Order;

import java.util.UUID;

public interface OrderService extends GenericService<Order, OrderDTO, UUID> {
}
