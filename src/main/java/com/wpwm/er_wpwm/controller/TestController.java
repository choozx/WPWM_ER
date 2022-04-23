package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.repository.mapping.GameIdMapping;
import com.wpwm.er_wpwm.search.ErService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Controller
public class TestController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private ErUserRepository erUserRepository;

    @Autowired
    private WebClient erWebClient;

    @Autowired
    private ErService erService;

    @PostMapping("/getUser")
    public UserInfo getUser(ErUserForm erUserForm) {

        UserInfo userInfo = null;
        if (erService.getNickname(erUserForm).isEmpty()) {
            erService.saveNickname(erUserForm);
        }
        userInfo = erService.getNickname(erUserForm).get();

        //저장된 userNum으로 매치 찾기
        return userInfo;
    }

    @PostMapping("/searchGames")
    public String searchGames(ModelAndView mv, ErUserForm erUserForm) {

        ErUser erUser = null;
        if (erService.getNickname(erUserForm).isEmpty()) {
            erService.saveNickname(erUserForm);
        }
        erUser = erService.getNickname(erUserForm).get();

       List<Games> gameIds = erService.getGameId(erUser);

       mv.addObject("aaa",null);

        //저장된 userNum으로 매치 찾기
        return "";
    }

    @PostMapping("/searchGames")
    public String searchGames(ModelAndView mv, ErUserForm erUserForm) {

        ErUser erUser = null;
        if (erService.getNickname(erUserForm).isEmpty()) {
            erService.saveNickname(erUserForm);
        }
        erUser = erService.getNickname(erUserForm).get();

        List<Games> gameIds = erService.getGameId(erUser);

        mv.addObject("aaa",null);

        //저장된 userNum으로 매치 찾기
        return "";
    }

    @PostMapping("/updateGames")
    public String updateGames(ErUserForm erUserForm){
        erService.saveGameId(erUserForm);
        return "";
    }

}
