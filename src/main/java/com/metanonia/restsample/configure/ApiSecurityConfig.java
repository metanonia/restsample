package com.metanonia.restsample.configure;

import com.metanonia.restsample.component.ApiKeyAuthFilter;
import com.metanonia.restsample.component.ApiKeyAuthManager;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Order(1)
@RequiredArgsConstructor
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    private final ApiKeyAuthFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        filter.setAuthenticationManager(new ApiKeyAuthManager());
        http
            .antMatcher("/private/**")
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

    }
}
