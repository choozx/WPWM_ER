package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Streamer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreamerRepository extends JpaRepository <Streamer, Long>{


    Streamer findByTwitchId(String twitchId);
}
