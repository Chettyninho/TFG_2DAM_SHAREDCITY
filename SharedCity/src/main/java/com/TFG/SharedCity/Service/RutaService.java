package com.TFG.SharedCity.Service;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Models.ValoracionRuta;
import com.TFG.SharedCity.Repository.RutaRepository;
import com.TFG.SharedCity.Repository.UsuarioRepository;
import com.TFG.SharedCity.Repository.Valoracion_RutaRepository;
import org.apache.catalina.startup.ListenerCreateRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RutaService {
    @Autowired
    RutaRepository rutaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    Valoracion_RutaRepository valoracionRutaRepository;

    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }
    public List<Ruta> findAllByUser(Integer id_usuario) {
        List<Ruta> todasLasRutas = rutaRepository.findAll();
        List<Ruta> rutasDeUsuario = new ArrayList();
        for (Ruta ruta : todasLasRutas) {
            if (ruta.getUsuarioPropietario().getId() == id_usuario) {
                rutasDeUsuario.add(ruta);
            }
        }
        return ordenarRutasPorValoraciones(rutasDeUsuario);
    }

          // Ordenación de la lista de rutas de un usuario según sus valoraciones
    public List<Ruta> ordenarRutasPorValoraciones(List<Ruta> rutasDeUsuario) {
        Map<Ruta, Double> promedioValoracionesPorRuta = new HashMap<>();

        // Calcular el promedio de las valoraciones para cada ruta
        for (Ruta ruta : rutasDeUsuario) {
            List<ValoracionRuta> valoracionesDeRuta = valoracionRutaRepository.findByRutaValorada(ruta);
            double promedioValoraciones = calcularPromedioValoraciones(valoracionesDeRuta);
            promedioValoracionesPorRuta.put(ruta, promedioValoraciones);
        }

        // Ordenar las rutas según el promedio de sus valoraciones
        rutasDeUsuario.sort((ruta1, ruta2) -> {
            double promedio1 = promedioValoracionesPorRuta.getOrDefault(ruta1, 0.0);
            double promedio2 = promedioValoracionesPorRuta.getOrDefault(ruta2, 0.0);
            return Double.compare(promedio2, promedio1); // Orden descendente
        });

        return rutasDeUsuario;
    }

    // Método para calcular el promedio de las valoraciones de una ruta
    private double calcularPromedioValoraciones(List<ValoracionRuta> valoraciones) {
        if (valoraciones.isEmpty()) {
            return 0.0; // Si no hay valoraciones, el promedio es 0
        }
        double sumaValoraciones = 0.0;
        for (ValoracionRuta valoracion : valoraciones) {
            sumaValoraciones += valoracion.getPuntos_Estrellas();
        }
        return sumaValoraciones / valoraciones.size();
    }

    //ORDENACION DE LA LISTA DE RUTAS DE UN USUARIO, segun sus valroaciones
//public List<Ruta> ordenarRutasPorValoraciones(List<Ruta> rutasDeUsuario){
//    List<Ruta> rutasOrdenadas = new ArrayList<>();
//    List<ValoracionRuta> valoraciones = valoracionRutaRepository.findAll();
//        for (Ruta ruta : rutasDeUsuario){
//           for (ValoracionRuta valoracionRuta : valoraciones){
//
//           }
//        }
//}
    public void saveRuta(Integer id_propietario,Ruta ruta) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        for(Usuario u : listaUsuarios){
            System.out.println(u);
            System.out.println("Id:usuario -> " + u.getId() + "/nIdPasado por peticion: " + id_propietario);
            if(u.getId()==id_propietario) {
                System.err.println("RUTA QUE LLEGA: " +ruta);
                ruta.setUsuarioPropietario(u);
                // Establecer el timestamp actual
                Date fechaActual = new Date();
                ruta.setFechaCreacion(fechaActual);
                System.err.println("RUTA QUE SE VA A INTRDUCIR: " + ruta);
                rutaRepository.save(ruta);
            }
        }

    }
}
