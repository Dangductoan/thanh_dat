package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.common.util.GiraMapper;
import com.toandd.project.thanhdat.source.dto.CustomerDTO;
import com.toandd.project.thanhdat.source.model.Customer;
import com.toandd.project.thanhdat.source.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface CustomerService extends GenericService<Customer, CustomerDTO, UUID> {
}
@Service
@Transactional
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final GiraMapper giraMapper;

    CustomerServiceImpl(CustomerRepository customerRepository, GiraMapper giraMapper) {
        this.customerRepository = customerRepository;
        this.giraMapper = giraMapper;
    }

    @Override
    public JpaRepository<Customer, UUID> getRepository() {
        return this.customerRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}
