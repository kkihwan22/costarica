package me.kkihwan.web.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.UUID;

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
