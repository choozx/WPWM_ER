package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.includeModel.GameId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ErServiceTest {

    @Autowired
    private MiddleService middleService;

    @Test
    public void asd(){
        GameId gameId = GameId.builder()
                .gameId(16692574)
                .userNum(null)
                .build();
        middleService.saveGameInfoFromClient(gameId);
    }

}