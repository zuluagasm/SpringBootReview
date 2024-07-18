package com.example.springbootReviewMongoDB.service.impl;

import com.example.springbootReviewMongoDB.dto.UsuarioDto;
import com.example.springbootReviewMongoDB.entity.Usuario;
import com.example.springbootReviewMongoDB.mapper.UsuarioMapper;
import com.example.springbootReviewMongoDB.repository.UsuarioRepository;
import com.example.springbootReviewMongoDB.service.UsuarioService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper){
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAll(Usuario usuario) {

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Usuario> example = Example.of(usuario, matcher);
        return usuarioRepository.findAll(example);
    }

    @Override
    public Page<Usuario> findAll(Usuario usuario, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Usuario> example = Example.of(usuario, matcher);
        Page<Usuario> usuarios = usuarioRepository.findAll(example, pageable);
        return usuarios;
    }

    @Override
    public List<UsuarioDto> findAllDto() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuarioDtos = usuarioMapper.toDtoList(usuarios);
        return usuarioDtos;
    }

    @Override
    public List<UsuarioDto> findAllDto(Usuario usuario) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Usuario> example = Example.of(usuario, matcher);
        List<Usuario> usuarios = usuarioRepository.findAll(example);
        List<UsuarioDto> usuarioDtos = usuarioMapper.toDtoList(usuarios);
        return usuarioDtos;
    }

    @Override
    public Page<UsuarioDto> findAllDto(Usuario usuario, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Usuario> example = Example.of(usuario, matcher);
        Page<Usuario> usuarios = usuarioRepository.findAll(example, pageable);
        return usuarioMapper.toDtoPage(usuarios);
    }

    @Override
    public Usuario findById(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(String id) {
        usuarioRepository.deleteById(id);
    }
}
