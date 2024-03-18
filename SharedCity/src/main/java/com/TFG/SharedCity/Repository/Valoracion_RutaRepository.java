package com.TFG.SharedCity.Repository;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Models.ValoracionRuta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Valoracion_RutaRepository extends JpaRepository<ValoracionRuta,Integer> {
    List<ValoracionRuta> findByRutaValorada(Ruta ruta);
}
