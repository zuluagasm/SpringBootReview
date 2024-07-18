package com.example.springbootReviewMongoDB.service;

import com.example.springbootReviewMongoDB.dto.UsuarioDto;
import com.example.springbootReviewMongoDB.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> findAll();
    public List<Usuario> findAll(Usuario usuario);
    public Page<Usuario> findAll(Usuario usuario, Pageable pageable);
    public List<UsuarioDto> findAllDto();
    public List<UsuarioDto> findAllDto(Usuario usuario);
    public Page<UsuarioDto> findAllDto(Usuario usuario, Pageable pageable);
    public Usuario findById(String id);
    public Usuario save(Usuario usuario);
    public void deleteById(String id);
}
