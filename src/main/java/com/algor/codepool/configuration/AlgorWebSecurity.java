package com.algor.codepool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AlgorWebSecurity extends WebSecurityConfigurerAdapter  {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("Steve")
                .password(pe.encode("S29t25e3v4e5"))
                .roles();
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring()
                //.antMatchers("/resources/**")
                .antMatchers("/**/*.html")
                .antMatchers("/**/*.htm")
                .antMatchers("/**/*.js")
                .antMatchers("/**/*.png")
                .antMatchers("/**/*.jpg")
                .antMatchers("/favicon.ico")
                .antMatchers("/**/*.css")
                .antMatchers("/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers( "/static/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().successForwardUrl("/index");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
