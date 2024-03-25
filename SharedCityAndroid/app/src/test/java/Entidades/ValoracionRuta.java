package Entidades;

public class ValoracionRuta {
    private Integer id;
    private Integer idUsuarioValorante;
    private String tituloValoracion;
    private String valoracion;
    private double puntosEstrellas;
    private Integer idRuta;

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

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
}