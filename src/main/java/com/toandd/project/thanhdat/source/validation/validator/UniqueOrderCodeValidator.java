package com.toandd.project.thanhdat.source.validation.validator;

import com.toandd.project.thanhdat.source.model.Order;
import com.toandd.project.thanhdat.source.repository.OrderRepository;
import com.toandd.project.thanhdat.source.validation.anotation.UniqueOrderCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueOrderCodeValidator implements ConstraintValidator<UniqueOrderCode, String> {
    private String messages;
    private final OrderRepository repository;

    public UniqueOrderCodeValidator(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueOrderCode constraintAnnotation) {
        this.messages = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Optional<Order> order = repository.findByCode(code);
        if(order.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(messages)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
