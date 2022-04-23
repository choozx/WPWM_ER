package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.repository.GamesRepository;
import com.wpwm.er_wpwm.search.client.ErClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ErService {

    private final ErUserRepository erUserRepository;
    private final GamesRepository gamesRepository;
    private final ErClient erClient;
    private final MiddleService middleService;


    public UserInfo getUser(ErUserForm erUserForm){

        if (middleService.getUserByDB(erUserForm).isEmpty()) {
            middleService.saveUserByClient(erUserForm);
        }
        ErUser erUser = middleService.getUserByDB(erUserForm).get();
        UserInfo userInfo = UserInfo.builder()
                .userNum(erUser.getUserNum())
                .nickName(erUser.getNickName())
                .build();
        return userInfo;
    }


}