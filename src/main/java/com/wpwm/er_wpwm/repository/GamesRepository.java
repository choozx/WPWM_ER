package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.repository.mapping.GameIdMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GamesRepository extends JpaRepository <Games, Long>{


    @Query(value = "select MAX(game_id) from games where (select * from games where user_num = ?1)", nativeQuery = true)
    String findMaxGameIdByUserNum(String user);

}
