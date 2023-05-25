package com.cognizant.facilityregistartion.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FacilitySecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
		        .antMatchers("/clinic/getAllClinic").hasRole("ADMIN")
				.antMatchers("/clinic/saveClinic").hasRole("ADMIN")
				.antMatchers("/facility/saveFacility").hasRole("ADMIN")
				.antMatchers("/patient/savePatient").hasAnyRole("ADMIN", "USER")
				.antMatchers("/patient/updatePatient").hasAnyRole("ADMIN", "USER")
				.antMatchers("/saveUser").hasRole("ADMIN")
				.antMatchers("/user").authenticated()
				.antMatchers("/patient/getAllPatient",
						"/facility/getAllFacility", "/getAllUser", "/facility/updateFacility")
				.permitAll()
				.and().formLogin()
				.and().httpBasic();
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	} ,"/patient/savePatient","/patient/updatePatient",

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
