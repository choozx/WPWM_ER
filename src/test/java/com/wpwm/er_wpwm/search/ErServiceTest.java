package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Games;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ErServiceTest {

    @Autowired
    private ErService erService;

    @Test
    public void 게임아이디얻기() {
        erService.saveGameId(ErUserForm.builder()
                        .userNum("1218167")
                        .build());
        List<Games> gamesList = erService.getGameId(ErUser.builder()
                .userNum("1218167")
                .build());

        log.info("result:{}",gamesList);
    }
}