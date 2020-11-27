package com.dass.SpringSecurityInAction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SCryptPasswordEncoder scryptPasswordEncoder() {
		return new SCryptPasswordEncoder();
	}

	@Autowired
	private CustomAuthenticaionProvider authProvider;

	public void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authProvider);
	}

	public void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
		http.addFilterAfter(new AuthenticaionLoggingFilter(), BasicAuthenticationFilter.class);
		http.formLogin().defaultSuccessUrl("/main", true);
		http.authorizeRequests().mvcMatchers("/hello").authenticated();
	}
}
