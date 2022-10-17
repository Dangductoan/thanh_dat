package com.toandd.project.thanhdat.source.repository;

import com.toandd.project.thanhdat.source.model.GroupProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupProductRepository extends JpaRepository<GroupProduct, UUID> {
}
