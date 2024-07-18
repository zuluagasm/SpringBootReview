package com.example.springbootReviewMongoDB.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class UsuarioDto {

    private String id;
    private String nombre;
    private String apellido;
    private String edad;
    private String fullName;

    public String getFullName() {
       return nombre + " " + apellido;
    }
    public void setFullName() {
        this.fullName = nombre + " " + apellido;
    }
}
