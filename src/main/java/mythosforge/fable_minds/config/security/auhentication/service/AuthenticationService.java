package mythosforge.fable_minds.config.security.auhentication.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import mythosforge.fable_minds.models.Users;
import mythosforge.fable_minds.repository.UserRepository;

@Service
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationService(
        AuthenticationManager authenticationManager, 
        JwtService jwtService, 
        UserRepository userRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public String authenticate(String username, String password) {
        // Autentica com o AuthenticationManager (que chama o UserDetailsService internamente)
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (Exception e) {
            throw new RuntimeException("Falha na autenticação", e);
        }
        
        // Busca o usuário completo do banco (para garantir acesso ao ID ou roles, se necessário)
        Users user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        // Gera um JWT
        return jwtService.generateToken(user);
    }
}