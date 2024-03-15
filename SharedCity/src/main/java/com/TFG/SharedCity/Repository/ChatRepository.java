package com.TFG.SharedCity.Repository;

import com.TFG.SharedCity.Models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
}
