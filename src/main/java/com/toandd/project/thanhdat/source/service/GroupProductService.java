package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.GroupProductDTO;
import com.toandd.project.thanhdat.source.model.GroupProduct;
import com.toandd.project.thanhdat.source.repository.GroupProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface GroupProductService extends GenericService<GroupProduct, GroupProductDTO, UUID> {
}
@Service
@Transactional
class GroupProductServiceImpl implements GroupProductService {

    private final GroupProductRepository groupProductRepository;
    private final GiraMapper giraMapper;

    GroupProductServiceImpl(GroupProductRepository groupProductRepository, GiraMapper giraMapper) {
        this.groupProductRepository = groupProductRepository;
        this.giraMapper = giraMapper;
    }

    @Override
    public JpaRepository<GroupProduct, UUID> getRepository() {
        return this.groupProductRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}
