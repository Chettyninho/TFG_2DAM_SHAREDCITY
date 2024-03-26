package com.TFG.SharedCity.Repository;

import com.TFG.SharedCity.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //List<Usuario> findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Query("SELECT DISTINCT u FROM Usuario u " +
            "WHERE u.id IN (" +
            "    SELECT idEmisor FROM Chat WHERE idReceptor = :userId " +
            "    UNION " +
            "    SELECT idReceptor FROM Chat WHERE idEmisor = :userId" +
            ")")
    List<Usuario> getChatsByUserId(Integer userId);
}
