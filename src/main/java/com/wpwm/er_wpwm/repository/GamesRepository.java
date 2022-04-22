package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GamesRepository extends JpaRepository <Games, Long>{

    List<Games> findByUserNum(String userNum);

    Optional<Games> findTopByUserNumOrderByGameIdDesc(String userNum);
}
