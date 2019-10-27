package com.yizuslabs.jobsfaith.controller;

import com.yizuslabs.jobsfaith.controller.exception.UsuarioIdMismatchException;
import com.yizuslabs.jobsfaith.controller.exception.UsuarioNotFoundException;
import com.yizuslabs.jobsfaith.persistence.model.TbUsuario;
import com.yizuslabs.jobsfaith.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Iterable findAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{name}")
    public List findByName(@PathVariable String nomUsuario) {
        return usuarioRepository.findByNomUsuario(nomUsuario);
    }

    @GetMapping("/{id}")
    public TbUsuario findOne(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(UsuarioNotFoundException::new);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TbUsuario create(@RequestBody TbUsuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepository.findById(id)
                .orElseThrow(UsuarioNotFoundException::new);
        usuarioRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public TbUsuario updateBook(@RequestBody TbUsuario usuario, @PathVariable Long id) {
        if (usuario.getCodUsuario() != id) {
            throw new UsuarioIdMismatchException();
        }
        usuarioRepository.findById(id)
                .orElseThrow(UsuarioNotFoundException::new);
        return usuarioRepository.save(usuario);
    }
}
