package de.fitcontrol.tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.var;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .antMatchers("/**").permitAll() // Public endpoints
                //.anyRequest().authenticated() // All other endpoints require authentication
                .anyRequest().permitAll()
            		)
            .csrf().disable();
//            .formLogin(form -> form
//                .loginPage("/login")
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .permitAll()
//            );
        
       // http.csrf().disable();


        return http.build();
    }
    
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Example in-memory authentication
        var user = User.withUsername("admin")
            .password("{noop}pass") // {noop} indicates plain text password, use a password encoder in production
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}

