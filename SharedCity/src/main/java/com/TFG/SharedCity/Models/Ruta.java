package com.TFG.SharedCity.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "RUTA")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ruta {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nombre;
    private double Distancia;
    @Column(name = "Fecha_Creacion")
    private Date fechaCreacion; // Cambié el nombre de la variable según convención

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_PROPIETARIO")
    private Usuario usuarioPropietario; // Cambié el nombre de la variable según convención


    //faltan las relaciones entre tablas
    //cuando se cree una nueva ruuta, se mandara desde android
    //lo que viene aqui a excepcion del id del usuario, que se mandara como parametro.
    //entocnes con ese se hará una busqueda entre todos los usuarios y el que coincida se asignara al u_valorado


}
