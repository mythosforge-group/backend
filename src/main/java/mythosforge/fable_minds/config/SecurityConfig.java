package mythosforge.fable_minds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // libera acesso total ao console H2
                .requestMatchers("/h2-console/**").permitAll()
                // todas as outras rotas precisam de autenticação
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults()) // formulário padrão de login
            .csrf(csrf -> csrf.disable())         // necessário pro H2 funcionar
            .headers(headers -> headers
                .frameOptions(frame -> frame.disable())        // necessário pro H2 funcionar
            );

        return http.build();
    }
}
