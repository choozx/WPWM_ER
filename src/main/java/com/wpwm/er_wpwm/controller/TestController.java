package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.includeModel.GameId;
import com.wpwm.er_wpwm.includeModel.GameInfo;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.search.ErService;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {


    @Autowired
    private ErService erService;

    @GetMapping("/getUser")
    public UserInfo getUser(ErUserForm erUserForm) {
        return erService.getUser(erUserForm);
    }

    @PostMapping("/getGames")
    public List<GameInfo> getGames(UserInfo userInfo) {
        List<GameId> gameId = erService.getGameId(userInfo);
        List<GameInfo> gameInfos = erService.getGameInfo(gameId);
        return gameInfos;
    }

    /*@PostMapping("/searchGames")
    public String searchGames(ErUserForm erUserForm) {

        ErUser erUser = null;
        if (erService.getUser(erUserForm).isEmpty()) {
            erService.saveNickname(erUserForm);
        }
        //erUser = erService.getNickname(erUserForm).get();

        List<Games> gameIds = erService.getGameId(erUser);

        mv.addObject("aaa", null);

        //저장된 userNum으로 매치 찾기
        return "";
    }*/

    /*@PostMapping("/updateGames")
    public String updateGames(ErUserForm erUserForm) {
        erService.saveGameId(erUserForm);
        return "";
    }*/

}
