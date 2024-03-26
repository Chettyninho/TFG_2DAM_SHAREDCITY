package com.TFG.SharedCity.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "chat")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Chat {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ID_EMISOR")
    private Integer idEmisor;

    @Column(name = "ID_RECEPTOR")
    private Integer idReceptor;

    @Column(name = "Mensaje")
    private String mensaje;

    @Column(name = "FechaHora")
    private Timestamp fechaHora;
}
