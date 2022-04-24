package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.MasteryLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MasteryRepository extends JpaRepository <MasteryLevel, Long>{


}
