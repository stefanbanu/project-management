package com.stefanbanu.pma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("myuser")
                    .password("pass")
                    .roles("USER")
                .and()
                .withUser("taz")
                    .password("pass2")
                    .roles("USER")
                .and()
                .withUser("managerUser")
                .password("pass3")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncode() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception {
        http.csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/projects/new")
                .hasRole("ADMIN")
                .antMatchers("/projects/save")
                .hasRole("ADMIN")
                .antMatchers("/")
                .authenticated();
//                .and()
//                .formLogin();
    }

}
