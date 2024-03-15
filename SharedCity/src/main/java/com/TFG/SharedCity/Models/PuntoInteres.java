package com.TFG.SharedCity.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "PUNTO_INTERES")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PuntoInteres {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nombre;
    private double Latitud;
    private double Longitud;
    private int ID_Ruta;

    //faltan las relaciones entre tablas

}
