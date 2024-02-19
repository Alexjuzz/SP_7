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
    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.authorizeHttpRequests(registry -> registry

//                .requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/task/**").permitAll()
//                .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/").permitAll()
                .requestMatchers(HttpMethod.POST, "/").permitAll()
                .anyRequest().permitAll()
        ).formLogin(Customizer.withDefaults()).csrf(Customizer.withDefaults()).build();
    }
}
