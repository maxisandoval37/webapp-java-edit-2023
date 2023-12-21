package dev.maxisandoval37.webappjavaedit2023.repository;

import dev.maxisandoval37.webappjavaedit2023.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String s);
}