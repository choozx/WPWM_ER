package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.includeModel.GameId;
import com.wpwm.er_wpwm.includeModel.GameInfo;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.includeModel.player.PlayerInfo;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.repository.GamesRepository;
import com.wpwm.er_wpwm.search.client.ErClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ErService {

    private final MiddleService middleService;


    public UserInfo getUser(ErUserForm erUserForm){

        if (middleService.getUserFromDB(erUserForm).isEmpty()) {
            middleService.saveUserFromClient(erUserForm);
        }
        ErUser erUser = middleService.getUserFromDB(erUserForm).get();
        UserInfo userInfo = UserInfo.builder()
                .userNum(erUser.getUserNum())
                .nickName(erUser.getNickName())
                .build();
        return userInfo;
    }

    public List<GameId> getGameId(UserInfo userInfo) {
        List<GameId> gameIds = middleService.getGameIdFromDB(userInfo);
        return gameIds;
    }

    public List<GameId> saveGameId(UserInfo userInfo) {
        UserInfo userInfoTest = UserInfo.builder()
                .nickName("쌍문동곡갱이")
                .userNum("1218167")
                .build();
        return middleService.saveGameIdFromClient(userInfoTest);
    }


    public List<GameInfo> getGameInfo(List<GameId> gameIds) {
        List<GameInfo> gameInfos = null;
        for (GameId gameId: gameIds) {
            List<PlayerInfo> playerInfos = middleService.getPlayerFromDB(gameId);
            GameInfo gameInfo = GameInfo.builder()
                    .gameId(gameId.getGameId())
                    .playerInfos(playerInfos)
                    .build();

            gameInfos.add(gameInfo);
        }
        return gameInfos;
    }

    public void saveGameInfo(List<GameId> gameIds) {
        for (GameId gameId : gameIds) {
          middleService.saveGameInfoFromClient(gameId);
        }
    }
}