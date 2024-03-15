package com.TFG.SharedCity.Controller;

import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Repository.UsuarioRepository;
import com.TFG.SharedCity.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inicio")
public class HomeController {

    @Autowired
    UsuarioRepository uRepo;


    @PostMapping("/login")
    public Usuario loguear(@RequestBody Usuario usuario) {
        List<Usuario> usuarios = uRepo.findAll();
        Usuario usuario2 = null;
        for (Usuario u : usuarios) {
            if(u.getPassword()!=null && u.getSalt()!=null){
                if (u.getUsername().equals(usuario.getUsername()) && u.getPassword().equals(comprobarContraseña(u,usuario.getPassword()))) {
                    usuario2 = u;
                    //System.out.println("ok");
                    break;
                }else{
                    usuario2 = new Usuario();
                    //System.out.println("NO");
                }
            }
        }
        return usuario2;
    }

    private String comprobarContraseña(Usuario usuario, String testPasword){
        byte[] salt = usuario.getSalt();
        String hashedPassword = UsuarioService.hashPassword(testPasword, salt);
        return hashedPassword;
    }


}
