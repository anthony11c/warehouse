package com.example.partsUnlimited.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Spring boot security configuration class.
@Configuration
@EnableWebSecurity      // Enables security for our application.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Securing the urls and allowing role-based access to these urls.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/api/v1/warehouse").hasRole("WAREHOUSE")
                .antMatchers("/api/v1/sales").hasRole("SALES")
                .antMatchers("/api/v1/salesAction").hasRole("SALES")
                .and().csrf().disable();
    }

    // In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sales").password("{noop}prodaja").roles("SALES");
        auth.inMemoryAuthentication().withUser("warehouse").password("{noop}skladiste").roles("WAREHOUSE");
    }
}
