package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.exception.GiraBusinessException;
import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.ProductDTO;
import com.toandd.project.thanhdat.source.model.Product;
import com.toandd.project.thanhdat.source.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.UUID;

public interface ProductService extends GenericService<Product, ProductDTO, UUID> {
    ProductDTO update(ProductDTO dto, Class<ProductDTO> dtoClass);
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


    @Override
    public ProductDTO update(ProductDTO dto, Class<ProductDTO> dtoClass) {
        Product product = productRepository.findById(dto.getId()).orElseThrow(
                () -> new GiraBusinessException("Not found")
        );
        product.setName(dto.getName());
        product.setCode(dto.getCode());
        product.setDescription(dto.getDescription());
        product.setTypeProduct(dto.getTypeProduct());
        product.setBuyPrice(dto.getBuyPrice());
        product.setFirstPrice(dto.getFirstPrice());
        product.setUrlImage(dto.getUrlImage());
        getRepository().save(product);
        return getMapper().map(product,dtoClass);
    }
}
