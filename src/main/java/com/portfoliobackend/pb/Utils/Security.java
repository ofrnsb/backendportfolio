package com.portfoliobackend.pb.Utils;

import com.portfoliobackend.pb.Services.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private loginService loginService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable()
      .authorizeHttpRequests(requests ->
        requests
          .requestMatchers("/register")
          .permitAll()
          .anyRequest()
          .authenticated()
      )
      .httpBasic()
      .and()
      .authenticationManager(authenticationManager(http));

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http)
    throws Exception {
    return http
      .getSharedObject(AuthenticationManagerBuilder.class)
      .userDetailsService(loginService)
      .passwordEncoder(bCryptPasswordEncoder)
      .and()
      .build();
  }
}
