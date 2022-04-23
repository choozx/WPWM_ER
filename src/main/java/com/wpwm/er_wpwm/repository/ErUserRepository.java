package com.wpwm.er_wpwm.repository;

import com.wpwm.er_wpwm.entity.ErUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ErUserRepository extends JpaRepository <ErUser, Long>{

    Optional<ErUser> findByNickName(String nickName);
}
