package me.kkihwan.web.shared.validator;

import lombok.*;
import org.slf4j.*;

import javax.validation.*;
import java.util.*;

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