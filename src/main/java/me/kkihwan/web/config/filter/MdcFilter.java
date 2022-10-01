package me.kkihwan.web.config.filter;

import org.slf4j.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebFilter
public class MdcFilter extends HttpFilter {
    private final static Logger LOG = LoggerFactory.getLogger(MdcFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String traceId = generateTraceId();
        LOG.debug("[{}] START.", traceId);
        try {
            MDC.put("traceId", traceId);
            chain.doFilter(request, response);
        } finally {
            LOG.debug("[{}] END.", traceId);
            MDC.clear();
        }
    }

    private String generateTraceId() {
        return UUID.randomUUID().toString();
    }
}
