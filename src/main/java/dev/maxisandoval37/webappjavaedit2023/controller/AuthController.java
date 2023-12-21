package dev.maxisandoval37.webappjavaedit2023.controller;

import dev.maxisandoval37.webappjavaedit2023.model.Usuario;
import dev.maxisandoval37.webappjavaedit2023.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login";
    }
}