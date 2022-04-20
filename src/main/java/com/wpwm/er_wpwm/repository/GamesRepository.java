package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.repository.mapping.GameIdMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamesRepository extends JpaRepository <Games, Long>{


}
