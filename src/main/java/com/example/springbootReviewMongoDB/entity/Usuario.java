package com.example.springbootReviewMongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class Usuario {

    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String apellido;
    @Field
    private String email;
    @Field
    private String telefono;
    @Field
    private String edad;
}
