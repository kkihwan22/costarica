package me.kkihwan.web.config.filter;


import com.fasterxml.jackson.databind.*;
import me.kkihwan.web.config.security.exception.*;
import me.kkihwan.web.shared.entrypoint.*;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.filter.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

public class ErrorHandleFilter extends OncePerRequestFilter {
    private final Logger log = LoggerFactory.getLogger(ErrorHandleFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        log.debug("[ filter ] execute error filter.");

        try {
            filterChain.doFilter(request, response);
        } catch (TokenExpiredException e) {
            logger.info("토큰의 유효기간이 만료되었습니다.");
            this.writeValue(response, UNAUTHORIZED, SecurityErrorCode.EXPIRED_TOKEN);

        } catch (UnauthorizationException e) {
            logger.info("유효하지 않는 토큰입니다. 원인 -[{}]", e);
            this.writeValue(response, UNAUTHORIZED, SecurityErrorCode.INVALID_TOKEN);

        } catch (RuntimeException e) {
            logger.info("인증 중 알수 없는 에러가 발생했습니다. reason : {}", e);
            this.writeValue(response, BAD_REQUEST, SecurityErrorCode.UNKNOWN_AUTH);
        }
    }

    private void writeValue(HttpServletResponse response, HttpStatus status, SecurityErrorCode error) throws IOException {
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Body<SimpleBodyData<String>> body = BodyFactory.failure(
                error.getCode(),
                error.getMessage(),
                "",
                new SimpleBodyData<>("error"));
        new ObjectMapper().writeValue(response.getOutputStream(), ResponseEntity.of(Optional.of(body)));
    }
}
