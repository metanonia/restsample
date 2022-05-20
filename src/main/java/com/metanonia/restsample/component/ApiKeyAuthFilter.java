package com.metanonia.restsample.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {
    private String API_KEY_AUTH_HEADER_NAME = "X-APIKEY";
    private String SIGN_HEADER_NAME = "X-SIGN";

    @Autowired
    public ApiKeyAuthFilter(ApiKeyAuthManager manager) {
        this.setAuthenticationManager(manager);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(API_KEY_AUTH_HEADER_NAME);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return request.getHeader(SIGN_HEADER_NAME);
    }

}
