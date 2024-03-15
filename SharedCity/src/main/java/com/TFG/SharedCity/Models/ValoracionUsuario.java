package com.TFG.SharedCity.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VALORACION_USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ValoracionUsuario {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_VALORANTE")
    private Usuario u_valorante;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_VALORADO")
    private Usuario u_valorado;

    @Column(name = "Titulo_valoracion")
    private String tituloValoracion;

    @Column(name = "Valoracion")
    private String valoracion;

    @Column(name = "Puntos_Estrellas")
    private double puntosEstrellas;

    //igual seria buena idea incluir un timestamp si el usuario puede hacer varias valoraciones a un mismo guia,
    //sino cambiamos un poco la logica en el Service y ya esta.


}
