package me.kkihwan.web.shared.entrypoint.exception;

import me.kkihwan.web.shared.exception.BusinessException;
import me.kkihwan.web.shared.exception.model.ErrorBodyData;

import java.util.List;

public class BadRequestParameterException extends BusinessException {
    public BadRequestParameterException(List<ErrorBodyData> errorBodyData) {
        super(400, "error.badrequestparameter", errorBodyData);
    }
}
