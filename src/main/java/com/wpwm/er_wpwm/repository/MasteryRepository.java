package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.MasteryLevel;
import com.wpwm.er_wpwm.includeModel.GameId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasteryRepository extends JpaRepository <MasteryLevel, Long>{

    List<MasteryLevel> findByGameIdAndUserNum(int GameId, String UserNum);
}
