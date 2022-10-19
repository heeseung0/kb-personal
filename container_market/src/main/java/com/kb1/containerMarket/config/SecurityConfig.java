package com.kb1.containerMarket.config;

import com.kb1.containerMarket.security.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()
                .antMatchers("/member/mypage", "/index")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .usernameParameter("username")
                .loginPage("/member/login")            // login page (Get 요청)
                .loginProcessingUrl("/member/login")   //  login service (Post요청)
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/");
    }
}
