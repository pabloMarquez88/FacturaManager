package com.facturamanager.security;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user11").password("secret1").roles("USER").and().withUser("admin").password("admin").roles("USER", "ADMIN")
		.and().withUser("PMarquezRuiz@bancopatagonia.com.ar").password("admin").roles("USER", "ADMIN").
		and().withUser("admin2").password("admin").roles("USER", "ADMIN").
		and().withUser("admin3").password("admin").roles("USER", "ADMIN").
		and().withUser("admin4").password("admin").roles("USER", "ADMIN").
		and().withUser("admin5").password("admin").roles("USER", "ADMIN").
		and().withUser("admin6").password("admin").roles("USER", "ADMIN").
		and().withUser("admin7").password("admin").roles("USER", "ADMIN").
		and().withUser("admin8").password("admin").roles("USER", "ADMIN").
		and().withUser("admin9").password("admin").roles("USER", "ADMIN").
		and().withUser("admin10").password("admin").roles("USER", "ADMIN").
		and().withUser("admin11").password("admin").roles("USER", "ADMIN").
		and().withUser("admin12").password("admin").roles("USER", "ADMIN").
		and().withUser("admin13").password("admin").roles("USER", "ADMIN").
		and().withUser("admin14").password("admin").roles("USER", "ADMIN").
		and().withUser("admin15").password("admin").roles("USER", "ADMIN").
		and().withUser("admin16").password("admin").roles("USER", "ADMIN").
		and().withUser("admin17").password("admin").roles("USER", "ADMIN").
		and().withUser("admin18").password("admin").roles("USER", "ADMIN").
		and().withUser("admin19").password("admin").roles("USER", "ADMIN").
		and().withUser("admin20").password("admin").roles("USER", "ADMIN").
		and().withUser("admin21").password("admin").roles("USER", "ADMIN").
		and().withUser("admin22").password("admin").roles("USER", "ADMIN").
		and().withUser("admin23").password("admin").roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	/**
	 * USER TIENE ACCESO A STUDENTS PERO A NADA MAS, ADMIN TIENE ACCESO A TODO.
	 */
	protected void configure(HttpSecurity http) throws Exception {
		// http.httpBasic().and().authorizeRequests().antMatchers("/students/**")
		// .hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
		// .csrf().disable().headers().frameOptions().disable();
		http.cors();
		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login")
				.successHandler(successHandler()).failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()).permitAll().and().logout().permitAll().and().csrf().disable();
		http.exceptionHandling().accessDeniedPage("/403").authenticationEntryPoint(delegatingAuthenticationEntryPoint());
	}
	
	@Bean
	public DelegatingAuthenticationEntryPoint delegatingAuthenticationEntryPoint() { 
	    LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints = new LinkedHashMap<RequestMatcher, AuthenticationEntryPoint>();
	    entryPoints.put(new AntPathRequestMatcher("/**"), new Http403ForbiddenEntryPoint());
	    DelegatingAuthenticationEntryPoint defaultEntryPoint = new DelegatingAuthenticationEntryPoint(entryPoints);
	    defaultEntryPoint.setDefaultEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
	    return defaultEntryPoint;
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		List<String> al = new ArrayList<>();
		al.add("http://localhost:4200");
		configuration.setAllowedOrigins(al);
		al = new ArrayList<>();
		al.add("HEAD");
		al.add("GET");
		al.add("POST");
		al.add("PUT");
		al.add("DELETE");
		configuration.setAllowedMethods(al);
		// setAllowCredentials(true) is important, otherwise:
		// The value of the 'Access-Control-Allow-Origin' header in the response
		// must not be the wildcard '*' when the request's credentials mode is
		// 'include'.
		configuration.setAllowCredentials(true);
		// setAllowedHeaders is important! Without it, OPTIONS preflight request
		// will fail with 403 Invalid CORS request
		al = new ArrayList<>();
		al.add("Authorization");
		al.add("Cache-Control");
		al.add("Content-Type");

		configuration.setMaxAge(4560000L);
		
		configuration.setAllowedHeaders(al);
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new MySavedRequestAwareAuthenticationSuccessHandler();
	}
}