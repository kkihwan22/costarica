package me.kkihwan.web.shared.support;

import org.springframework.web.context.request.*;

import javax.servlet.http.*;

public class ContextHolderSupport {
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) getRequestAttributes()).getRequest();
    }

    public static RequestAttributes getRequestAttributes() {
        return RequestContextHolder.getRequestAttributes();
    }
}