package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.dto.StreamerForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Streamer;
import com.wpwm.er_wpwm.includeModel.GameId;
import com.wpwm.er_wpwm.includeModel.GameInfo;
import com.wpwm.er_wpwm.includeModel.StreamerInfo;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.includeModel.player.PlayerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ErService {

    private final MiddleService middleService;


    public UserInfo getUser(String nickName){

        if (middleService.getUserFromDB(nickName).isEmpty()) {
            middleService.saveUserFromClient(nickName);
        }
        ErUser erUser = middleService.getUserFromDB(nickName).get();
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
        return middleService.saveGameIdFromClient(userInfo);
    }


    public List<GameInfo> getGameInfo(List<GameId> gameIds) {
        List<GameInfo> gameInfos = new ArrayList<>();
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
            if (middleService.getPlayerFromDB(gameId).isEmpty()){
                middleService.savePlayerFromClient(gameId);
            }
        }
    }

    public StreamerInfo getStreamer(StreamerForm streamerForm) {
        if (middleService.getStreamerFromDB(streamerForm).isEmpty()){
            return null;
        } else {
            Streamer streamer = middleService.getStreamerFromDB(streamerForm).get();
            StreamerInfo streamerInfo = StreamerInfo.builder()
                    .twitchId(streamer.getTwitchId())
                    .nickName(streamer.getErNickname())
                    .userNum(streamer.getUserNum())
                    .build();
            return streamerInfo;
        }
    }

    public void saveStreamer(UserInfo userInfo) {
        middleService.saveStreamerFromClient(userInfo);
        //https://api.twitch.tv/helix/users/follows?to_id=<user ID> 이거 써서 위에서 받아온 블서id랑 트위치 팔로워수 같이 저장
        //트위치 API는 분당 30개로 제한 하기때문에 일정 시간대에서 스트리머 테이블에 있는 정보를 updtae하는 방식으로 해야될듯
    }

    public List<StreamerInfo> testGetStreamer() {
        return middleService.testgetStreamerFromDB();
    }

    public void autoSaveStreamer() {
        List<String> streamerList = new ArrayList<>();
        streamerList.add("여린말");
        streamerList.add("응쏜");
        streamerList.add("twitch끔붕어");
        streamerList.add("twitch모좀");

        for (String nickName: streamerList) {
            middleService.testSaveStreamerFromClient(nickName);
        }

    }

}