package com.collegeDays.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
		.failureUrl("/login?error").permitAll();
	http.logout().logoutSuccessUrl("/");
    }
}