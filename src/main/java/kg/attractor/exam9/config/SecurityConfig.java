package kg.attractor.exam9.config;

import kg.attractor.exam9.service.impl.AuthUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))

                .httpBasic(Customizer.withDefaults())
                .formLogin(login -> login
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/auth/login?error=true")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll())
//                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(authorize -> authorize

//                        User

                                .requestMatchers("user/profile").fullyAuthenticated()
                                .requestMatchers("user/**").permitAll()
                                .requestMatchers("/flights/**").fullyAuthenticated()


                                .requestMatchers("/").permitAll()

                                .anyRequest().fullyAuthenticated()
                );

        return http.build();
    }

}