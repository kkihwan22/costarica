package me.kkihwan.web.config.aspect;

import me.kkihwan.web.shared.support.ContextHolderSupport;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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