package com.databasegroup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
  
// 方法级别的安全性
//@Configuration
//@EnableGlobalMethodSecurity(jsr250Enabled=true)
public class MethodSecurityConfig extends WebSecurityConfigurerAdapter {
  
}