package me.kkihwan.web.shared.support;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ContextHolderSupport {
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) getRequestAttributes()).getRequest();
    }

    public static RequestAttributes getRequestAttributes() {
        return RequestContextHolder.getRequestAttributes();
    }
}