package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.includeModel.Participant;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.search.ErService;
import com.wpwm.er_wpwm.type.MasteryType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class TestController {


    @Autowired
    private ErService erService;

    @PostMapping("/getUser")
    public UserInfo getUser(ErUserForm erUserForm) {
        return erService.getUser(erUserForm);
    }

    @PostMapping("/getGames")
    public List<Participant> getGames(UserInfo userInfo) {

        List<Participant> participants = null;

        //participants = erService.get


        return participants;
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
