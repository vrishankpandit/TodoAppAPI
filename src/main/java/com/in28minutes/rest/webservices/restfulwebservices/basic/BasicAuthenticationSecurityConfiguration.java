package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration	
public class BasicAuthenticationSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        

		http.authorizeHttpRequests(auth->auth
										.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
										.anyRequest().authenticated()
 //anables access to preflight request
									
									); //enables authentication on evry api call
		
		http.httpBasic(Customizer.withDefaults());//enables basic auth so user can enter username,password
		
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.csrf().disable();
		
		return http.build();
	}
}
