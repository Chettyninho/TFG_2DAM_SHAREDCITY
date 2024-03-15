package com.TFG.SharedCity.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Fecha_Nacimeinto")
    private Date fechaNacimeinto;

    @Column(name = "Numero_de_rutas")
    private int numeroDeRutas;

    @Column(name = "Pais")
    private String pais;

    @Column(name = "Localidad")
    private String localidad;

    @Column(name = "email")
    private String email;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Salt")
    private byte[] salt;

    @Column(name = "Foto_perfil")
    private byte[] fotoPerfil;

    @Column(name = "Guia")
    private boolean guia;

    // Constructor, getters y setters
}
