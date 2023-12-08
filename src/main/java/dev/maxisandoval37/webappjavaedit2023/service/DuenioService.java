package dev.maxisandoval37.webappjavaedit2023.service;

import dev.maxisandoval37.webappjavaedit2023.model.Duenio;
import dev.maxisandoval37.webappjavaedit2023.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DuenioService {

    @Autowired
    private DuenioRepository duenioRepository;

    public List<Duenio> listarDuenios(){
        return duenioRepository.findAll();
    }

    public Duenio guardarDuenio(Duenio duenio){
        return duenioRepository.save(duenio);
    }
}
