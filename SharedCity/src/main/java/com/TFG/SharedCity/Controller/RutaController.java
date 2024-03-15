package com.TFG.SharedCity.Controller;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaController {
    @Autowired
    RutaService rutaService;
    //listarTodas
    @GetMapping("/getAll")
    public List<Ruta> getAllRutas(){
        return rutaService.findAll();
    }
    //GuardarRuta
    @PostMapping("/saveRuta/{id_propietario}")
    public void guardarRuta(@PathVariable Integer id_propietario, @RequestBody Ruta ruta){
        rutaService.saveRuta(id_propietario, ruta);
    }
    //valorarRuta
    //tendra que acceder a las valoraciones de las rutas
}
