package com.TFG.SharedCity.Repository;

import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Models.ValoracionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Valoracion_UsuarioRepository extends JpaRepository<ValoracionUsuario,Integer> {
    List<ValoracionUsuario> findByuValorado(Usuario usuario);
    List<ValoracionUsuario> findByuValorante(Usuario usuario);
}
