package com.jdc.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecuritySettings extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser(User.builder().username("admin").authorities("ADMIN").password("{noop}admin"))
			.withUser(User.builder().username("member").authorities("MEMBER").password("{noop}member"));
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests()
//			.mvcMatchers("/admin/**").hasRole("ADMIN")
//			.mvcMatchers("/member/**").hasAnyRole("MEMBER", "ADMIN");
		
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.antMatchers("/member/**").hasAnyAuthority("MEMBER", "ADMIN");
		
		http.formLogin()
			.loginPage("/views/login.jsp")
			.loginProcessingUrl("/login")
			.usernameParameter("loginId")
			.passwordParameter("password");
		
		http.logout()
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
		
		http.exceptionHandling()
			.accessDeniedPage("/forbidden");
		
	}

}
