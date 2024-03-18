package com.TFG.SharedCity.Service;

import com.TFG.SharedCity.Models.Ruta;
import com.TFG.SharedCity.Models.Usuario;
import com.TFG.SharedCity.Models.ValoracionRuta;
import com.TFG.SharedCity.Models.ValoracionUsuario;
import com.TFG.SharedCity.Repository.UsuarioRepository;
import com.TFG.SharedCity.Repository.Valoracion_UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    Valoracion_UsuarioRepository valoracion_usuarioRepository;

    public List<Usuario> getAll() {
        List<Usuario> listaTotalUsuarios =  usuarioRepository.findAll();
        //List<Usuario> listaTotalUsuariosOrdenada =  ordenarUsuarios(listaTotalUsuarios);

        return listaTotalUsuarios;
    }
//  OJO CUIDAAAAAO AQUI
//                private List<Usuario> ordenarUsuarios(List<Usuario> listaTotalUsuarios) {
//
//                        Map<Usuario, Double> promedioValoracionesPorUsuario = new HashMap<>();
//
//                        // Calcular el promedio de las valoraciones por usr
//                        for (Usuario usuario : listaTotalUsuarios) {
//                            List<ValoracionUsuario> valoracionesDeUsuario = valoracion_usuarioRepository.findByu_valorado(usuario);
//                            double promedioValoraciones = calcularPromedioValoraciones(valoracionesDeUsuario);
//                            promedioValoracionesPorUsuario.put(usuario, promedioValoraciones);
//                        }
//
//                    // Ordenar los usuarios según el promedio de sus valoraciones
//                    listaTotalUsuarios.sort((usuario1, usuario2) -> {
//                        double promedio1 = promedioValoracionesPorUsuario.getOrDefault(usuario1, 0.0);
//                        double promedio2 = promedioValoracionesPorUsuario.getOrDefault(usuario2, 0.0);
//                        return Double.compare(promedio2, promedio1); // Orden descendente
//                    });
//
//                    return listaTotalUsuarios;
//                    }
//                private double calcularPromedioValoraciones(List<ValoracionUsuario> valoraciones) {
//                    if (valoraciones.isEmpty()) {
//                        return 0.0; // Si no hay valoraciones, el promedio es 0
//                    }
//                    double sumaValoraciones = 0.0;
//                    for (ValoracionUsuario valoracion : valoraciones) {
//                        sumaValoraciones += valoracion.getPuntosEstrellas();
//                    }
//                    return sumaValoraciones / valoraciones.size();
//                }

    public Usuario comprobarYRegistrarUsuario(Usuario usuario) {
        // Verificar si el nombre de usuario ya existe
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            // El nombre de usuario ya está en uso, retorna null
            return null;
        }

        // Verificar si el correo electrónico ya existe
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            // El correo electrónico ya está en uso, retorna null
            return null;
        }

        // Si el nombre de usuario y el correo electrónico no existen, entonces hashear la contraseña
        byte[] salt = generateSalt();
        String hashedPassword = hashPassword(usuario.getPassword(), salt);
        usuario.setPassword(hashedPassword);
        usuario.setSalt(salt);

        // Guardar el usuario en la base de datos
        System.out.println("Entro2");
        return usuarioRepository.save(usuario);
    }
    //generar sal y generar contraseña hasseada
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // Tamaño recomendado para el salt: 16 bytes
        random.nextBytes(salt);
        return salt;
    }
    public static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Agregar el salt a la contraseña antes de aplicar el hash
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Convertir el hash a una representación en formato Base64 para meterlo a la bbdd
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción apropiadamente
            e.printStackTrace();
            return null;
        }
    }

}
