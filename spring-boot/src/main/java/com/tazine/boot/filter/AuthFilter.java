package com.tazine.boot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 登录验证过滤器
 *
 * @author frank
 * @since 1.0.0
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //filterChain.doFilter();
    }

    @Override
    public void destroy() {

    }
}
