package com.toandd.project.thanhdat.source.service;

import com.toandd.project.thanhdat.common.service.GenericService;
import com.toandd.project.thanhdat.source.dto.ProductDTO;
import com.toandd.project.thanhdat.source.model.Product;

import java.util.UUID;

public interface ProductService extends GenericService<Product, ProductDTO, UUID> {
}
