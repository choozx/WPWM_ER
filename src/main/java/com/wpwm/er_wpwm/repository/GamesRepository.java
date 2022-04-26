package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.GameIds;
import com.wpwm.er_wpwm.includeModel.GameInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GamesRepository extends JpaRepository <GameIds, Long>{

    List<GameIds> findByUserNum(String userNum);

    Optional<GameIds> findTopByUserNumOrderByGameIdDesc(String userNum);

}
