package com.centro_de_entremiento.App_centro_de_entrenamiento.infrastructure.config.security;


import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.model.User;
import com.centro_de_entremiento.App_centro_de_entrenamiento.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[]  PUBLIC_SOURCES = {"/login","/register","/swagger-ui/**","v3/api-docs/**","/v3/api-docs.yaml",
                                            "/swagger-ui.html"};


    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(crsf-> crsf.disable())
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers(PUBLIC_SOURCES).permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(provider())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authentication)throws Exception{
        return authentication.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider provider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

    public UserDetailsService userDetailsService(){
       return email -> {
            User user = userRepository.findByEmail(email);
            if(user == null){
                throw new UsernameNotFoundException("user not found");
            }
           return user;
        };
    }
}
