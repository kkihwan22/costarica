package me.kkihwan.web.config.aspect;

import me.kkihwan.web.shared.support.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;

@Component @Aspect
public class LoggingAspect {
    private final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* me.kkihwan.web.*.entrypoint..*Controller.*(..) )")
    void pointcut() {}

    @Around("pointcut()")
    public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // TODO: request에 대해서 어떻게 로그를 찍을지 고민
        HttpServletRequest httpRequest = ContextHolderSupport.getHttpServletRequest();
        Object result = proceedingJoinPoint.proceed();
        LOG.info("[response] {}", result);
        return result;
    }
}