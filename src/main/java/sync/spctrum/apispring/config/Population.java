package sync.spctrum.apispring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Population implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public Population(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        Usuario m1 = new Usuario(1L, "Winycios", "winycios@gmail.com", passwordEncoder.encode("Madalena13#"), "", LocalDate.of(2008, 2, 15), "Homem", 64.5, "Basico", true, new Objetivo());
        m1.setObjetivo(new Objetivo(1L, "Ser forte", m1));
        Usuario m2 = new Usuario(2L, "Ana", "Ana@gmail.com", passwordEncoder.encode("Madalena15#"), "", LocalDate.of(2007, 5, 13), "Mulher", 70.8, "Basico", false, new Objetivo());
        m2.setObjetivo(new Objetivo(2L, "Ser Feliz", m2));
        Usuario m3 = new Usuario(3L, "Gustavo", "Gustavo@gmail.com", passwordEncoder.encode("Madalena1#"), "", LocalDate.of(2005, 1, 10), "Homem", 100.0, "Basico", true, new Objetivo());
        m3.setObjetivo(new Objetivo(3L, "Pegar mulher", m3));

        usuarioRepository.saveAll(Arrays.asList(m1, m2, m3));
    }
}
