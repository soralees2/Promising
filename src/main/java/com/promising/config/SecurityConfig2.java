/*
 * package com.promising.config;
 * 
 * import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.WebSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig2 extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override public void configure(WebSecurity web) throws Exception { web
 * .ignoring() .requestMatchers(
 * PathRequest.toStaticResources().atCommonLocations()); } }
 * 
 */