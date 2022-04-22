package com.api.exemplo.controllers;

import com.api.exemplo.models.Usuario;
import com.api.exemplo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioService.buscarTodosUsuarios();
    }

}
