package me.kkihwan.web.shared.entrypoint;

import me.kkihwan.web.shared.entrypoint.exception.BadRequestParameterException;
import me.kkihwan.web.shared.exception.model.ErrorBodyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import java.util.*;
import java.util.stream.*;

public interface BaseRestController {
    Logger log = LoggerFactory.getLogger(BaseRestController.class);
    default void hasError(BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            return;
        }

        List<ErrorBodyData> errorBodyData = bindingResult.getFieldErrors()
                .stream()
                .map(err -> new ErrorBodyData(err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());
        log.debug("errors: {}", errorBodyData);
        throw new BadRequestParameterException(errorBodyData);
    }
}
