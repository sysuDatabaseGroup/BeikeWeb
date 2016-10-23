package com.databasegroup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


// WebӦ�ü���İ�ȫ��
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("USER");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http
      	.authorizeRequests()
      		.anyRequest().authenticated() //����������վ��Ҫ������֤
      		.and()
      	.formLogin()
      		.loginPage("/authLogin") // ��֤ҳ��
      		.permitAll()
      		.and()
      	.httpBasic()
      		.and()
      	.csrf().disable(); // csrf ���Բ��ù�
      
//        .and()
//        .requiresChannel()
//        	.antMatchers("/login").requiresSecure();
    }
  
}