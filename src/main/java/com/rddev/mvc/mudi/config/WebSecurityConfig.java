
package com.rddev.mvc.mudi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authz -> authz
        .antMatchers("/home/**").permitAll()
        .anyRequest().authenticated()
      )
      .formLogin(form ->
        form.loginPage("/login")
          .permitAll()
          .defaultSuccessUrl("/usuario/pedido")
      )
      .logout()
        .logoutUrl("/logout")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .logoutSuccessUrl("/home")
        .permitAll()
      .and()
        .csrf().disable();
      
    return http.build();
  }

  @Bean
  public UserDetailsManager users(DataSource dataSource, PasswordEncoder encoder) {
    UserDetails user = 
      User.builder()
        .username("raphael")
        .password(encoder.encode("ra1234"))
        .roles("ADM")
        .build();

    UserDetails user2 = 
      User.builder()
        .username("joao")
        .password(encoder.encode("joao"))
        .roles("ADM")
        .build();

    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    if (! users.userExists(user.getUsername())) users.createUser(user);;
    if (! users.userExists(user2.getUsername())) users.createUser(user2);;
    return users;
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
