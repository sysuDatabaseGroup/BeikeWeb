package com.databasegroup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Java配置
// Web应用级别的安全性
//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("USER");
		// 临时认证账号密码
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http
      	.authorizeRequests()
      		.antMatchers("/home").authenticated() //限制所有网站都要经过认证
      		.anyRequest().permitAll()
      		.and()
      	.formLogin()
      		.loginPage("/authLogin") // 认证页面
      		.permitAll()
      		.and()
      	.httpBasic()
      		.and()
      	.csrf().disable(); // csrf 可以不用管
      
//        .and()
//        .requiresChannel()
//        	.antMatchers("/login").requiresSecure();
    }
  
}