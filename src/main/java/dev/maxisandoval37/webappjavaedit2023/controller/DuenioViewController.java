package dev.maxisandoval37.webappjavaedit2023.controller;

import dev.maxisandoval37.webappjavaedit2023.model.Duenio;
import dev.maxisandoval37.webappjavaedit2023.service.DuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
//@RequestMapping("/api/duenio") 😀
public class DuenioViewController {

    @Autowired
    private DuenioService duenioService;

    @GetMapping("/duenios")
    public String listarDuenios(Model model){
        List<Duenio> duenios = duenioService.listarDuenios();
        model.addAttribute("duenios", duenios);
        return "duenio";
    }

    @GetMapping("/agregarDuenio")
    public String mostrarFormularioAgregarDuenio(Model model){
        model.addAttribute("duenio", new Duenio());
        return "agregarDuenio";
    }

    @PostMapping("/guardarDuenio")
    public String guardarDuenio(Duenio duenio){
        duenioService.guardarDuenio(duenio);
        return "redirect:/duenios";
    }

}