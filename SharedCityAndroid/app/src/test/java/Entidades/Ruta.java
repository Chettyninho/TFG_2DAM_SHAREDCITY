package Entidades;

import java.security.Timestamp;

public class Ruta {
    private Integer id;
    private String nombre;
    private float distancia;
    private Timestamp fechaCreacion;
    private Integer idUsuarioPropietario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuarioPropietario() {
        return idUsuarioPropietario;
    }

    public void setIdUsuarioPropietario(Integer idUsuarioPropietario) {
        this.idUsuarioPropietario = idUsuarioPropietario;
    }
}
