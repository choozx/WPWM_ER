package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.Equipment;
import com.wpwm.er_wpwm.entity.MasteryLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository <Equipment, Long>{

    Equipment findByGameIdAndUserNum(int gameId, String userNum);
}
