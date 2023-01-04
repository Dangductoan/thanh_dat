package com.toandd.project.thanhdat.source.validation.validator;

import com.toandd.project.thanhdat.source.model.TypeProduct;
import com.toandd.project.thanhdat.source.repository.TypeProductRepository;
import com.toandd.project.thanhdat.source.validation.anotation.UniqueTypeProductName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueTypeProductNameValidator implements ConstraintValidator<UniqueTypeProductName, String> {
    private String messages;
    private final TypeProductRepository repository;

    public UniqueTypeProductNameValidator(TypeProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueTypeProductName constraintAnnotation) {
        this.messages = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        Optional<TypeProduct> typeProduct = repository.findByName(name);
        if (typeProduct.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(messages)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
