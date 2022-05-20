package com.metanonia.restsample.component;

import com.metanonia.restsample.service.CommonService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
public class ApiKeyAuthManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        String credentials = (String) authentication.getCredentials();

        try {
            if (CommonService.Sha512(principal).matches(credentials) == false) {
                throw new BadCredentialsException("The API key was not found or not the expected value.");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new BadCredentialsException(e.toString());
        }
        authentication.setAuthenticated(true);
        return authentication;
    }
}
