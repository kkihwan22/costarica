package me.kkihwan.web.shared.entrypoint;

import me.kkihwan.web.shared.exception.*;
import me.kkihwan.web.shared.exception.model.ErrorBodyData;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * TODO
 * WebRequest or HttpServletRequest 에 대해서 정확히 파악
 * TODO
 * private 메소드로 URI 정보 / 헤더 / 전달 데이터를 로그에 남기는 코드 작성
 * TODO
 * Cause 에 정보가 잘 담기는지 확인 및 테스트 ( trace 가 되는지가 중요하다.)
 */
@RestControllerAdvice
public class AppRestControllerAdvisor {
    private final Logger LOG = LoggerFactory.getLogger(AppRestControllerAdvisor.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Body<List<ErrorBodyData>>> handleBusinessException(RuntimeException e) {
        BusinessException exception = (BusinessException) e;
        LOG.error("[ error ] point : {}", e.getClass().getSimpleName());
        LOG.error("[ error ] reason : {}", e);

        List<ErrorBodyData> errorBodyData = Optional.ofNullable(exception.getErrorBodyData()).orElse(Collections.emptyList());
        return ResponseEntity.badRequest()
                .body(BodyFactory.failure(
                        exception.getCode(), exception.getMessage(), "", errorBodyData));
    }

    @ExceptionHandler(UnknownException.class)
    public ResponseEntity<Body<Void>> handleUnknownException(RuntimeException e) {
        UnknownException exception = (UnknownException) e;
        LOG.error("[ error ] point : {}", e.getClass().getSimpleName());
        LOG.error("[ error ] reason : {}", e);

        return ResponseEntity.badRequest()
                .body(BodyFactory.failure(
                        exception.getCode(), exception.getMessage(), "", null));
    }
}