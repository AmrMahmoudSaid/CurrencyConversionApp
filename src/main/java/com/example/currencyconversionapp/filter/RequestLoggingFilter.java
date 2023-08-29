package com.example.currencyconversionapp.filter;

import java.io.IOException;



import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("in Request filter ....");
        String requestDetails = "Request - Method: " + ((HttpServletRequest) servletRequest).getMethod()
                + ", URI: " + ((HttpServletRequest) servletRequest).getRequestURI();
        log.info(requestDetails);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}