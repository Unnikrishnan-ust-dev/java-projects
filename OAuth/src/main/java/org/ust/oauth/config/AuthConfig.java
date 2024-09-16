//package org.ust.oauth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.http.SecurityHeaders;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Objects;
//
//@Configuration
//@EnableMethodSecurity
//public class AuthConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        Object AbstractHttpConfigurer;
//        http
//                .authorizeHttpRequests(request -> {
//                    request.requestMatchers(new RequestMatcher() {
//                        @Override
//                        public boolean matches(HttpServletRequest request) {
//                            return Objects.equals(request.getRequestURI(), "/login");
//                        }
//                    }).permitAll();
//                    request.anyRequest().authenticated();
//                })
//                .csrf(csrf->csrf.disable());
//        return http.build();
//    }
//}
