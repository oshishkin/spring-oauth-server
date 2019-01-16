package com.wemboo.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;



@Configuration
@Order(1)
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.requestMatcher(
                        (RequestMatcher) new OrRequestMatcher(                            
                            new AntPathRequestMatcher("/login"),
                            new AntPathRequestMatcher("/logout"), 
                            new AntPathRequestMatcher("/oauth/authorize"),
                            new AntPathRequestMatcher("/oauth/confirm_access")
                            ))
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .and()
        .logout().permitAll();


        http.headers().frameOptions().disable();
    
    }


//  Uncomment to use inMemory auth instead of H2 based user service    
/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("wemboo")
            .password(passwordEncoder.encode("wemboo"))
            .roles("USER");
    }
*/


//  Comment to use inMemory auth instead of H2 based user service   

    @Autowired
    private MyUserDetailsService userDetailsService;
     
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
          = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }    

    
 
}