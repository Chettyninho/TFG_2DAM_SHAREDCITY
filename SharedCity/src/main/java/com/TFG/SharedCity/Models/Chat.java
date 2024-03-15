package com.TFG.SharedCity.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "CHAT")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Chat {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_EMISOR")
    private Usuario u_emisor;
    @ManyToOne
    @JoinColumn(name = "ID_RECEPTOR")
    private Usuario u_receptor;

    private String Mensaje;
    private Timestamp FechaHora;

}
