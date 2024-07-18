package com.example.springbootReviewMongoDB.repository;

import com.example.springbootReviewMongoDB.entity.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    <S extends Usuario> List<S> findAll(Example<S> usuario);
    <S extends Usuario> List<S> findAll(Example<S> example, Sort sort);
    <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable);
}
