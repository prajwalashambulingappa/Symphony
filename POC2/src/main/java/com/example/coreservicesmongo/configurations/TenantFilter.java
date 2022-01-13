package com.example.coreservicesmongo.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configurable
public class TenantFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(TenantFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        logger.info("request_url= "+String.valueOf(httpServletRequest.getRequestURI()));
        String tenantid= httpServletRequest.getHeader("X-Tenant-ID");
        logger.info("Tenant ID: " +tenantid);

        if(tenantid.trim().length()==4){
            int id = Integer.parseInt(tenantid);
            TenantContext.createContext(id);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            TenantContext.clear();
        }else{
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
        this.destroy();
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
