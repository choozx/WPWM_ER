package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.GameIds;
import com.wpwm.er_wpwm.entity.Player;
import com.wpwm.er_wpwm.includeModel.GameId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository <Player, Long>{

    List<Player> findByGameId(int gameId);
}
