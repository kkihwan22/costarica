package me.kkihwan.web.shared.application;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.*;
import java.util.Set;

@Getter
public abstract class ParameterValidator<T> {
    private final Logger LOG = LoggerFactory.getLogger(ParameterValidator.class);
    private Validator validator;

    public ParameterValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    protected void validate() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            LOG.info("violations : {}", violations);
            throw new ConstraintViolationException(violations);
        }
    }
}