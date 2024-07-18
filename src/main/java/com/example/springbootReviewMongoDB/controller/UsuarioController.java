package com.example.springbootReviewMongoDB.controller;

import com.example.springbootReviewMongoDB.dto.UsuarioDto;
import com.example.springbootReviewMongoDB.entity.Usuario;
import com.example.springbootReviewMongoDB.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping("/filter")
    public List<Usuario> findFilter(@RequestBody Usuario usuario) {
        return usuarioService.findAll(usuario);
    }

    @PostMapping("/paged")
    public Page<Usuario> findPaged(@RequestBody Usuario usuario, Pageable pageable) {
        return usuarioService.findAll(usuario, pageable);
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") String id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String id) {
        usuarioService.deleteById(id);
    }

    @PostMapping("/dto")
    public List<UsuarioDto> findAllDto(){
        return usuarioService.findAllDto();
    }

    @PostMapping("/dto/filtered")
    public List<UsuarioDto> findAllDtoFiltered(@RequestBody Usuario usuario){
        return usuarioService.findAllDto(usuario);
    }

    @PostMapping("/dto/paged")
    public Page<UsuarioDto> findAllDtoPaged(@RequestBody Usuario usuario, Pageable pageable){
        return usuarioService.findAllDto(usuario, pageable);
    }
}
