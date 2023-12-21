package dev.maxisandoval37.webappjavaedit2023.service;

import dev.maxisandoval37.webappjavaedit2023.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.encontrarUsuarioPorNombre(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: ".concat(username));
        }

        return User.withUsername(usuario.getNombre())
                .password("{bcrypt}"+usuario.getContrasena())
                .build();
    }

    /*
    Ejemplo usuario con contrasena hardcodeada (en texto plano)
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return User.withUsername("user")
                    .password("{noop}pass")
                    .roles("USER")
                    .build();
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado "+username);
        }
    }*/
}
