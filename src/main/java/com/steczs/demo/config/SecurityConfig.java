package com.steczs.demo.config;

import com.steczs.demo.Servcie.Impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  允许所有用户访问"/"和"/index.html"
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/hi/**").permitAll()
                .antMatchers("/index/**").permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/zs")
                .hasAuthority("admin")//用户自定义的权限，返回的UserDetails的Authority只要与这里匹配就可以，这里不需要加ROLE_
                //.access("@MyRbacService.findAuthority(request,authentication)")//指定我们自己写的方法控制权限
                //.hasRole("ADMIN")//用hasRole时，在我们返回的UserDetails的Authority需要加Role_ADMIN
                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                .and()
                .formLogin()//表单登陆
                .loginPage("/login.html")   //  登录页
                .failureUrl("/login-error.html").permitAll()
                .failureForwardUrl("/test.html").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
