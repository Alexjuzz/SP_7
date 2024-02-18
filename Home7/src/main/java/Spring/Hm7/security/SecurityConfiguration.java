package Spring.Hm7.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security)throws  Exception{
        return  security.authorizeHttpRequests(registry -> registry
                        .requestMatchers(HttpMethod.GET, "/api/task/{id}**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/task").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/task/{id}**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/task/{id}**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/user/{1}**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/user/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/user/{id}**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/user/{id}**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()
        ).formLogin(Customizer.withDefaults()).build();
    }
}
