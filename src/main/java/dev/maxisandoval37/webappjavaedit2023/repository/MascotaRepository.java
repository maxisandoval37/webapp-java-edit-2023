package dev.maxisandoval37.webappjavaedit2023.repository;

import dev.maxisandoval37.webappjavaedit2023.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    //TODO: Implementar metodos personalizados
}
