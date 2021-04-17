package com.github.mabutamail.tipograf.security;

import org.springframework.transaction.annotation.Transactional;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {

    @Transactional
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
