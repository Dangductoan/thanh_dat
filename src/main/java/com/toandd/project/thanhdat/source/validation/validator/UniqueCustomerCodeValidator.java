package com.toandd.project.thanhdat.source.validation.validator;

import com.toandd.project.thanhdat.source.model.Customer;
import com.toandd.project.thanhdat.source.repository.CustomerRepository;
import com.toandd.project.thanhdat.source.validation.anotation.UniqueCustomerCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueCustomerCodeValidator implements ConstraintValidator<UniqueCustomerCode, String> {
    private String messages;
    private final CustomerRepository repository;

    public UniqueCustomerCodeValidator(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueCustomerCode constraintAnnotation) {
        this.messages = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Optional<Customer> customer = repository.findByCode(code);
        if (customer.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(messages)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
