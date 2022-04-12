package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.ErUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ErUserRepository extends JpaRepository <ErUser, Long>{

    List<ErUser> findAllByName(String name);
}
