package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	 DataSource dataSource;
	
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
	   "select username,password, enabled from users where username=?")
	  .authoritiesByUsernameQuery(
	   "select username, role from user_roles where username=?");
	 } 
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests()
	  .antMatchers("/admin**").hasAuthority("LIBRARIAN")
	  .antMatchers("/principal**").hasAuthority("PRINCIPAL")  
	  .anyRequest().permitAll()
	  .and()
	    .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
	    .failureUrl("/login?login_error=1")
	    .usernameParameter("j_username").passwordParameter("j_password")
	  .and()
	    .logout().logoutSuccessUrl("/login?logout").logoutUrl("/j_spring_security_logout") 
	   .and()
	   .exceptionHandling().accessDeniedPage("/403")
	  .and()
	    .csrf();
	 }
	
}
