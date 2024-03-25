package com.TFG.SharedCity.Controller;

import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Models.ValoracionUsuario;
import com.TFG.SharedCity.Service.UsuarioService;
import com.TFG.SharedCity.Service.Valoracion_UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    //tendra que acceder a las valoraciones de los usuarios

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    Valoracion_UsuarioService valoracion_usuarioService;
    @PostMapping("/saveUser") //hace tanto la funcion de insert como de update.
    public Usuario saveUser(@RequestBody Usuario usuario){
        System.out.println(usuario);
        System.out.println("Entro");
        return usuarioService.comprobarYRegistrarUsuario(usuario); //COMPROBAR Y REGISTRAR NO EXISTE AUN
    }
    @GetMapping("/getAllUsers")
        public List<Usuario> getAllUsers(){
        return usuarioService.getAll();
    }

    @PostMapping("/valorar/{id_entidadValorante}/{id_valorado}")
    public void valorarUsuario(@PathVariable Integer id_entidadValorante, @PathVariable Integer id_valorado, @RequestBody ValoracionUsuario valUsuario){
        System.out.println("eval " + id_entidadValorante + "\nEvalorador: " + id_valorado);
        valoracion_usuarioService.valorarUsuario(id_entidadValorante, id_valorado, valUsuario);
    }
//valoraciones quese le han hecho a unusuario
    @GetMapping("/getAllValoraciones/{id_usuario}")
    public List<ValoracionUsuario> getAllValoracionesUsr(@PathVariable Integer id_usuario){
        return usuarioService.getListaValoraciones(id_usuario);
    }
//valoraciones que yo he hecho
    @GetMapping("/getAllValoracionesQueYoHeHecho/{id_usuario}")
    public List<ValoracionUsuario> getAllValoracionesQueYoHeHecho(@PathVariable Integer id_usuario){
        return usuarioService.getListaValoracionesQueYoHeHecho(id_usuario);
    }

}
