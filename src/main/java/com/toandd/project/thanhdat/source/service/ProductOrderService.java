package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.ProductOrderDTO;
import com.toandd.project.thanhdat.source.model.ProductOrder;
import com.toandd.project.thanhdat.source.repository.ProductOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ProductOrderService extends GenericService<ProductOrder, ProductOrderDTO, UUID> {
}
@Service
@Transactional
class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrderRepository productOrderRepository;
    public final GiraMapper giraMapper;

    ProductOrderServiceImpl(ProductOrderRepository productOrderRepository, GiraMapper giraMapper) {
        this.productOrderRepository = productOrderRepository;
        this.giraMapper = giraMapper;
    }

    @Override
    public JpaRepository<ProductOrder, UUID> getRepository() {
        return this.productOrderRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}
