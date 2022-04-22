package com.api.exemplo.services;

import com.api.exemplo.models.Usuario;
import com.api.exemplo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarUsuarioPorId(long id){
        return usuarioRepository.findById(id);
    }

    public List<Usuario> buscarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

}
