package com.TFG.SharedCity.Service;

import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Models.ValoracionUsuario;
import com.TFG.SharedCity.Repository.UsuarioRepository;
import com.TFG.SharedCity.Repository.Valoracion_UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Service
public class Valoracion_UsuarioService {
    @Autowired
    Valoracion_UsuarioRepository valoracion_usuarioRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    public void valorarUsuario(Integer id_EntidadValorante, Integer id_valorado, ValoracionUsuario valUsuario){
        System.out.println(valUsuario);
        ArrayList<Usuario> totalUsuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        //recorremos la lista y asignamos los valorescoincidentes a valoracionUsuario
        for (Usuario u : totalUsuarios) {
            if(u.getId() == id_EntidadValorante){
                valUsuario.setU_valorante(u);
            }
            if(u.getId() == id_valorado){
                valUsuario.setU_valorado(u);
            }
        }

        valoracion_usuarioRepository.save(valUsuario);
    }
}
