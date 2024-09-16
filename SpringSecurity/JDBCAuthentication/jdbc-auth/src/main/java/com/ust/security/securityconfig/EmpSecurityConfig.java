package com.ust.security.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class EmpSecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((authorize)->authorize.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());	
		
		return http.build();
	}
	
	@Bean
	UserDetailsManager users(DataSource dataSource) {
		UserDetails user = User.builder()
			.username("bond")
			.password("james")
			.roles("ADMIN")
			.build();
		UserDetails admin = User.builder()
			.username("bean")
			.password("admin")
			.roles("USER")
			.build();
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.createUser(user);
		users.createUser(admin);
		return users;
	}
	
//	@Bean
//	JdbcUserDetailsManager userDetialsService() {
//		UserDetails userDetails = User.builder().
//				username("bean").
//				password(passwordEncoder().encode("ADMIN")).roles("USER").build();
//		
//		UserDetails adminDetails = User.builder().
//				username("bond").
//				password(passwordEncoder().encode("james")).roles("ADMIN").build();
//		JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//		manager.createUser(userDetails);
//		manager.createUser(adminDetails);
//		return manager ;
//	}
}
