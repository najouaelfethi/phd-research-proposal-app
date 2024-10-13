package com.phdwebsite.phdwebsite.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
	

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/**", "/candidature/error",
                                 "/candidature/documents","/candidature/viewDocument/**", "/candidature/professor/candidatures",
                                 "/candidature/professor", "/candidature/candidatureForm",
                                 "/candidature/form", "/candidature/submit","/candidature/update", "/student/**",
                                 "/student/propositions", "/student/propositions/list",
                                 "/student/propositions/details", "/details/**", "/admin/propositions",
                                 "/admin/propositions/list", "/admin/propositions/details", "/admin/**",
                                 "/professor/**", "/professor/propositions", "/professor/propositions/add",
                                 "/professor/add", "/professor/propositions/details", "/propositions/details",
                                 "/professor/propositions/edit", "/propositions/edit", "/disciplines",
                                 "/disciplines/add", "/specializations/add", "/propositions/add",
                                 "/propositions/edit", "/propositionsAdminDashboard", "/userManagment",
                                 "/specializations", "/userEdit/**", "/studentDashboard", "/adminDashboard",
                                 "/professorDashboard", "/register", "/img/**", "/roleSelection", "/css/**", "/js/**")
                .permitAll() // Allow public access to these paths
                .requestMatchers("/deleteMyList/**").permitAll()
                .requestMatchers("/saveUser/**").permitAll()
                .requestMatchers("/candidature/**").permitAll()
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin(form -> form
                .loginPage("/login") // Custom login page
                .loginProcessingUrl("/login") // Endpoint for login processing
                .defaultSuccessUrl("/roleSelection", true)
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll() // Allow logout
            );

        return http.build();
    }
    /*@Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    
}
