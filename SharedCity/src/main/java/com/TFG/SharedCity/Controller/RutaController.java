package com.TFG.SharedCity.Controller;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Models.ValoracionRuta;
import com.TFG.SharedCity.Models.ValoracionUsuario;
import com.TFG.SharedCity.Service.RutaService;
import com.TFG.SharedCity.Service.Valoracion_RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaController {
    @Autowired
    RutaService rutaService;
    @Autowired
    Valoracion_RutaService valoracion_rutaService;
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
    //listarTodas de usuario y ordenar por valoracion
    @GetMapping("/getAll/{id_usuario}")
    public List<Ruta> getAllRutas(@PathVariable Integer id_usuario){
        return rutaService.findAllByUser(id_usuario);
    }
    //valorarRuta
    @PostMapping("/valorar/{id_entidadValorante}/{id_ruta}")
    public void valorarUsuario(@PathVariable Integer id_entidadValorante, @PathVariable Integer id_ruta, @RequestBody ValoracionRuta valoracionRuta){
        System.out.println("eval " + id_entidadValorante + "\nRuta: " + id_ruta);
        valoracion_rutaService.valorarRuta(id_entidadValorante, id_ruta, valoracionRuta);
    }


    //FALTA HACER...
    // acceder a las valoraciones de las rutas
    //...
}
