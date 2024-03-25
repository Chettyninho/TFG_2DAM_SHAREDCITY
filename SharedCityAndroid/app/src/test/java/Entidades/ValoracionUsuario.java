package Entidades;

public class ValoracionUsuario {
    private Integer id;
    private Integer idUsuarioValorante;
    private Integer idUsuarioValorado;
    private String tituloValoracion;
    private String valoracion;
    private double puntosEstrellas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuarioValorante() {
        return idUsuarioValorante;
    }

    public void setIdUsuarioValorante(Integer idUsuarioValorante) {
        this.idUsuarioValorante = idUsuarioValorante;
    }

    public Integer getIdUsuarioValorado() {
        return idUsuarioValorado;
    }

    public void setIdUsuarioValorado(Integer idUsuarioValorado) {
        this.idUsuarioValorado = idUsuarioValorado;
    }

    public String getTituloValoracion() {
        return tituloValoracion;
    }

    public void setTituloValoracion(String tituloValoracion) {
        this.tituloValoracion = tituloValoracion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public double getPuntosEstrellas() {
        return puntosEstrellas;
    }

    public void setPuntosEstrellas(double puntosEstrellas) {
        this.puntosEstrellas = puntosEstrellas;
    }
}