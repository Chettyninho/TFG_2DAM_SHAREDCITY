package com.TFG.SharedCity.Models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UsuarioChat implements Serializable {

    private Integer id;
    private String nombre;

    public UsuarioChat(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

}
