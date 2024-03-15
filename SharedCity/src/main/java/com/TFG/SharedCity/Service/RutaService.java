package com.TFG.SharedCity.Service;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Repository.RutaRepository;
import com.TFG.SharedCity.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
public class RutaService {
    @Autowired
    RutaRepository rutaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

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
