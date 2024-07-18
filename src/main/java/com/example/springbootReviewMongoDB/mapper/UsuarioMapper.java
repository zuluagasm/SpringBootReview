package com.example.springbootReviewMongoDB.mapper;

import com.example.springbootReviewMongoDB.dto.UsuarioDto;
import com.example.springbootReviewMongoDB.entity.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDto toDto(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return usuarioDto;
    }

    public List<UsuarioDto> toDtoList(List<Usuario> usuario){
        List<UsuarioDto> usuarioDtoList = usuario.stream().map(user -> toDto(user)).collect(Collectors.toList());
        return usuarioDtoList;
    }

    public Page<UsuarioDto> toDtoPage(Page<Usuario> usuarioPage){
        Page<UsuarioDto> usuarioDtoPage = usuarioPage.map(usuario -> toDto(usuario));
        return usuarioDtoPage;
    }
}
