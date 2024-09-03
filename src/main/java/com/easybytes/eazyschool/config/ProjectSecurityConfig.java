package com.easybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;




@Configuration
public class ProjectSecurityConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers("/h2-console/**").ignoringRequestMatchers("/public/**").and()
                .authorizeRequests()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/displayMessages").hasRole("ADMIN")
                .requestMatchers("/Home").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/Holidays/**").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/public/**").permitAll()

                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().authorizeRequests().requestMatchers("/h2-console/**").permitAll()
        .and().httpBasic();
        http.headers().frameOptions().disable();

        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}54321")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }    }
