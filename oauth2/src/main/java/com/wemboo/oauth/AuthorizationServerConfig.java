package com.wemboo.oauth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    
 
    @Override
    public void configure(
        AuthorizationServerSecurityConfigurer oauthServer) throws Exception {

          oauthServer
                    .tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()");

    }
 

    @Override
    public void configure(
        ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
          .withClient("webclient")
          .secret(passwordEncoder().encode("secret"))
          .authorizedGrantTypes("authorization_code")
          .scopes("webclient")
          .autoApprove(true) 
          .redirectUris("https://localhost:8081/api/code")
          .accessTokenValiditySeconds(86400) //Access token is only valid for 2 minutes.
//          .refreshTokenValiditySeconds(600)                   
          ; 
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }   

}