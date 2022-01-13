package com.example.poc1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TenantFilter implements Filter {
//    @RequestMapping(path = "/tenant-id", method= RequestMethod.GET)
//    public String doFilter (@RequestHeader("X-TenantID") String tenantName) {
//        TenantContext.setCurrentTenant(tenantName);
//
//        return ("hello from" + tenantName);
//    }


    Logger logger = LoggerFactory.getLogger(TenantFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //HttpServletResponse httpResponse = (HttpServletResponse) response;
        logger.info("request url= "+String.valueOf(httpRequest.getRequestURI()));

        String tenantId = httpRequest.getHeader("X-Tenant-Id");

        if(tenantId.length()==4){
            int id = Integer.parseInt(tenantId);
            TenantContext tenantContext = new TenantContext(id);
            tenantContext.createContext(id);
        }

        logger.info("requested tenant id: "+tenantId);
        chain.doFilter(request,response);
    }
}
