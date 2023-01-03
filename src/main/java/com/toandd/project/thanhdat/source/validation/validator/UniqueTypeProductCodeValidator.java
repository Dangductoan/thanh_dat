package com.toandd.project.thanhdat.source.validation.validator;

import com.toandd.project.thanhdat.source.model.TypeProduct;
import com.toandd.project.thanhdat.source.repository.TypeProductRepository;
import com.toandd.project.thanhdat.source.validation.anotation.UniqueTypeProductCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueTypeProductCodeValidator implements ConstraintValidator<UniqueTypeProductCode, String> {

    private final TypeProductRepository repository;
    private String message;

    public UniqueTypeProductCodeValidator(TypeProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueTypeProductCode constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Optional<TypeProduct> typeProduct = repository.findByCode(code);
        if (typeProduct.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
