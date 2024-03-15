package com.TFG.SharedCity.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VALORACION_RUTA")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ValoracionRuta {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_VALORANTE")
    private Usuario u_valorante;

    private String Titulo_valoracion;
    private String Valoracion;
    private double Puntos_Estrellas;
    @ManyToOne
    @JoinColumn(name = "ID_Ruta")
    private Ruta rutaValorada;

}
