package dev.maxisandoval37.webappjavaedit2023.service;

import dev.maxisandoval37.webappjavaedit2023.model.Duenio;
import dev.maxisandoval37.webappjavaedit2023.model.Mascota;
import dev.maxisandoval37.webappjavaedit2023.repository.DuenioRepository;
import dev.maxisandoval37.webappjavaedit2023.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DuenioRepository duenioRepository;

    public Mascota obtenerMascotaPorId(Long id){
        return mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la mascota"));
    }

    public List<Mascota> listarMascotas(){
        //Sort sortBy = Sort.by(Sort.Direction.DESC, "nombre").ignoreCase();;

        return mascotaRepository.findAllOrderByNombreIgnoreCaseDesc();
    }

    public Mascota guardarMascota(Mascota mascota, Long idDuenio){
        Duenio duenio = duenioRepository.findById(idDuenio).orElseThrow(() -> new RuntimeException("No se encontro el duenio"));
        mascota.setDuenio(duenio);
        return mascotaRepository.save(mascota);
    }

    public void eliminarMascota(Long id){
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);

        if (mascotaOptional.isPresent()){
            mascotaRepository.delete(mascotaOptional.get());
        }
        else {
            throw new RuntimeException("Mascota no encontrada al momento de la eliminacion");
        }
    }

    public void actualizarMascota(Long id, Mascota mascotaActualizada){
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);

        if (mascotaOptional.isPresent()){
            Mascota mascotaExistente = mascotaOptional.get();
            mascotaExistente.setNombre(mascotaActualizada.getNombre());
            mascotaExistente.setEdad(mascotaActualizada.getEdad());
            mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
            mascotaExistente.setDuenio(mascotaActualizada.getDuenio());

            mascotaRepository.save(mascotaExistente);
        }
        else {
            throw new RuntimeException("Mascota no encontrada al momento de la actualizacion");
        }
    }
}