package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.ProductDTO;
import com.toandd.project.thanhdat.source.model.Product;
import com.toandd.project.thanhdat.source.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ProductService extends GenericService<Product, ProductDTO, UUID> {
}
@Service
@Transactional
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final GiraMapper giraMapper;

    ProductServiceImpl(ProductRepository productRepository, GiraMapper giraMapper) {
        this.productRepository = productRepository;
        this.giraMapper = giraMapper;
    }

    @Override
    public JpaRepository<Product, UUID> getRepository() {
        return this.productRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}
