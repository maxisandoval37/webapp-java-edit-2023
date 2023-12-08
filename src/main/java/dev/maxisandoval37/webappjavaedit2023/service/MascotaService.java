package dev.maxisandoval37.webappjavaedit2023.service;

import dev.maxisandoval37.webappjavaedit2023.model.Duenio;
import dev.maxisandoval37.webappjavaedit2023.model.Mascota;
import dev.maxisandoval37.webappjavaedit2023.repository.DuenioRepository;
import dev.maxisandoval37.webappjavaedit2023.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DuenioRepository duenioRepository;

    public List<Mascota> listarMascotas(){
        return mascotaRepository.findAll();
    }

    public void guardarMascota(Mascota mascota, Long idDuenio){
        Duenio duenio = duenioRepository.findById(idDuenio).orElseThrow(() -> new RuntimeException("No se encontro el duenio"));
        mascota.setDuenio(duenio);
        mascotaRepository.save(mascota);
    }
}