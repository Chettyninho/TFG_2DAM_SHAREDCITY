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



}
