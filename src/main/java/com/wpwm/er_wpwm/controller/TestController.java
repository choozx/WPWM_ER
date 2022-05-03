package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.dto.StreamerForm;
import com.wpwm.er_wpwm.includeModel.GameId;
import com.wpwm.er_wpwm.includeModel.GameInfo;
import com.wpwm.er_wpwm.includeModel.StreamerInfo;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.search.ErService;
import lombok.extern.slf4j.Slf4j;
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
        return erService.getUser(erUserForm.getNickname());
    }

    @GetMapping("/getGames")
    public List<GameInfo> getGames(UserInfo userInfo) {
        List<GameId> gameIds = erService.getGameId(userInfo);
        List<GameInfo> gameInfos = erService.getGameInfo(gameIds);
        return gameInfos;
    }

    @PostMapping("/updateGames")
    public void updateGames(UserInfo userInfo) {
        List<GameId> gameIds = erService.saveGameId(userInfo);
        erService.saveGameInfo(gameIds);    //위에서 받아오는 gameId중 gameInfo에 저장되어있는 gameId가 있다면 그것은 걸러서 조회 안함 erServie에 로직 추가해야됨
    }

    @GetMapping("/getStreamer")
    public StreamerInfo getStreamer(StreamerForm streamerForm) {
        return erService.getStreamer(streamerForm);
    }

    @PostMapping("/updateStreamer")
    public void updateStreamer(StreamerForm streamerForm){
        UserInfo userInfo = erService.getUser(streamerForm.getErNickname());//getUser의 파라미터를 생각좀 해봐야할듯
        erService.saveStreamer(userInfo);
    }

    @GetMapping("/testGetStreamer")
    public List<StreamerInfo> testGetStreamer() {
        return erService.testGetStreamer();
    }

    @PostMapping("/autoUpdateStreamer")
    public void autoUpdateStreamer(){
        erService.autoSaveStreamer();
    }

}
