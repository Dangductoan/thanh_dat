package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.TypeProductDTO;
import com.toandd.project.thanhdat.source.model.TypeProduct;
import com.toandd.project.thanhdat.source.repository.TypeProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface TypeProductService extends GenericService<TypeProduct, TypeProductDTO, UUID> {
}
@Service
@Transactional
class TypeProductServiceImpl implements TypeProductService {

    private final TypeProductRepository typeProductRepository;
    private final GiraMapper giraMapper;

    TypeProductServiceImpl(TypeProductRepository typeProductRepository, GiraMapper giraMapper) {
        this.typeProductRepository = typeProductRepository;
        this.giraMapper = giraMapper;
    }

    @Override
    public JpaRepository<TypeProduct, UUID> getRepository() {
        return this.typeProductRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}
