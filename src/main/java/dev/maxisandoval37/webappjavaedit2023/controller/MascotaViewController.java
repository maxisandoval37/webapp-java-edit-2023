package dev.maxisandoval37.webappjavaedit2023.controller;

import dev.maxisandoval37.webappjavaedit2023.model.Mascota;
import dev.maxisandoval37.webappjavaedit2023.service.DuenioService;
import dev.maxisandoval37.webappjavaedit2023.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class MascotaViewController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private DuenioService duenioService;

    @GetMapping("/mascotas")
    public String listarMascotas(Model model){
        List<Mascota> mascotas = mascotaService.listarMascotas();
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }

    @GetMapping("/agregarMascota")
    public String mostrarFormularioAgregarMascota(Model model){
        model.addAttribute("duenios", duenioService.listarDuenios());
        return "agregarMascota";
    }

    @PostMapping("/guardarMascota")
    public String guardarMascota(Mascota mascota, @RequestParam Long idDuenio){
        mascotaService.guardarMascota(mascota, idDuenio);
        return "redirect:/mascotas";
    }
}