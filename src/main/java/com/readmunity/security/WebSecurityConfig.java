package com.readmunity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/public/error/*","/error/*").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/bootstrap/**").permitAll()
                .antMatchers("/markdown/**").permitAll()
                .antMatchers("/**/*.js").permitAll()
                .antMatchers("/**/*.css").permitAll()
                .antMatchers("/sign/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/sign/signIn").failureUrl("/sign/signIn-error")
                .defaultSuccessUrl("/").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER").and()
//                .withUser("admin").password("admin").roles("USER", "ADMIN");
        auth.userDetailsService(new CustUserDetailsService());
    }

}