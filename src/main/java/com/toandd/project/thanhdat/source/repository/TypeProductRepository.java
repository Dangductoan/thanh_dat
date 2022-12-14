package com.toandd.project.thanhdat.source.repository;

import com.toandd.project.thanhdat.source.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, UUID> {
    Optional<TypeProduct> findByCode(String code);

    Optional<TypeProduct> findByName(String name);
}
