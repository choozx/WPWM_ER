package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.repository.mapping.GameIdMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GamesRepository extends JpaRepository <Games, Long>{

    List<Games> findByUserNum(String userNum);

    @Query(value = "select * from games where user_num = ?1 order by game_id desc limit 1)", nativeQuery = true)
    String findMaxGameIdByUserNum(String user);

    Optional<Games> findTopByUserNumOrderByGameIdDesc(String userNum);
}
