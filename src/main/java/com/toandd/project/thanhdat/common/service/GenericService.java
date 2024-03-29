package com.toandd.project.thanhdat.common.service;

import com.toandd.project.thanhdat.common.exception.GiraBusinessException;
import com.toandd.project.thanhdat.common.model.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface GenericService<T extends BaseEntity, D, I> {
    JpaRepository<T, I> getRepository();

    ModelMapper getMapper();

    //find all dto
    @Transactional(readOnly = true)
    default List<D> findAllDto(Class<D> clazz) {
        return getRepository().findAll().stream()
                .map(model -> getMapper().map(model, clazz))
                .collect(Collectors.toList());

    }
    // find all dto pageable
    @Transactional(readOnly = true)
    default List<D> findAllDto(Pageable page, Class<D> clazz) {
        return getRepository().findAll(page).stream()
                .map(model -> getMapper().map(model, clazz))
                .collect(Collectors.toList());

    }
    //find by id
    default D findById(I id,Class<D> dtoClass) {
        T model = getRepository().findById(id).orElseThrow(() -> new GiraBusinessException("Not found"));
        return getMapper().map(model,dtoClass);
    };
    //save dto
    default D save(D dto, Class<T> modelClass, Class<D> dtoClass) {
        T model = getMapper().map(dto, modelClass);
        T saveModel = getRepository().save(model);
        return getMapper().map(saveModel, dtoClass);
    }
    //D update(D dto, Class<T> modelClass, Class<D> dtoClass);
//    default D update(I id,D dto, Class<T> modelClass, Class<D> dtoClass) {
//        T model = getRepository().findById(id).orElseThrow(() -> new GiraBusinessException("Not found"));
//
//    }

    default List<T> findByIds(List<I> ids) {
        return getRepository().findAllById(ids);
    };
    //update dto





}
