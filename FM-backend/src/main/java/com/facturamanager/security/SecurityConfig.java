package com.facturamanager.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user11").password("secret1")
				.roles("USER").and().withUser("admin").password("admin")
				.roles("USER", "ADMIN");
	}
	// Authorization : Role -> Access
	/**
	 * USER TIENE ACCESO A STUDENTS PERO A NADA MAS,
	 * ADMIN TIENE ACCESO A TODO.
	 */
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic().and().authorizeRequests().antMatchers("/students/**")
//				.hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
//				.csrf().disable().headers().frameOptions().disable();
		
		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
		.permitAll().and().csrf().disable();
		http.exceptionHandling().accessDeniedPage("/403");
		
		
	}
}