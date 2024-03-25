package com.TFG.SharedCity.Service;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Models.ValoracionRuta;
import com.TFG.SharedCity.Repository.RutaRepository;
import com.TFG.SharedCity.Repository.UsuarioRepository;
import com.TFG.SharedCity.Repository.Valoracion_RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Valoracion_RutaService {
    @Autowired
    Valoracion_RutaRepository valoracion_rutaRepository;
    @Autowired
    RutaRepository rutaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    public void valorarRuta(Integer id_EntidadValorante, Integer id_ruta, ValoracionRuta valoracionRuta){
        System.out.println(valoracionRuta);
        ArrayList<Usuario> totalUsuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        ArrayList<Ruta> totalRutas = (ArrayList<Ruta>) rutaRepository.findAll();
        //recorremos la lista y asignamos los valorescoincidentes a valoracionUsuario
        for (Usuario u : totalUsuarios) {
            if(u.getId() == id_EntidadValorante){
                valoracionRuta.setU_valorante(u);
            }
        }
        for (Ruta r : totalRutas){
            if(r.getId() == id_ruta){
                valoracionRuta.setRutaValorada(r);
            }
        }
        valoracion_rutaRepository.save(valoracionRuta);
    }

    public List<ValoracionRuta> getAllValoraciones(Integer idRuta) {
        List<ValoracionRuta> totalValoraciones = valoracion_rutaRepository.findAll();
        List<ValoracionRuta> valoracionesDeUnaRuta = new ArrayList<>();
        for (ValoracionRuta v : totalValoraciones){
            if (v.getRutaValorada().getId()==idRuta){
                valoracionesDeUnaRuta.add(v);
            }
        }
        return valoracionesDeUnaRuta;
    }
}
