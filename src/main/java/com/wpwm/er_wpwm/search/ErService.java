package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.exception.ErrorPageException;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.repository.GamesRepository;
import com.wpwm.er_wpwm.repository.mapping.GameIdMapping;
import com.wpwm.er_wpwm.search.service.ErClient;
import com.wpwm.er_wpwm.search.service.model.ErRequest;
import com.wpwm.er_wpwm.search.service.model.ErRequest.ErGameInfoRequest;
import com.wpwm.er_wpwm.search.service.model.ErRequest.ErGameIdRequest;
import com.wpwm.er_wpwm.search.service.model.ErRequest.ErUserRequest;
import com.wpwm.er_wpwm.search.service.model.ErResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErUserResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErGameIdResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErGameIdResponse.GameInfo;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErUserResponse.ErUserResponseInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ErService {

    private final ErUserRepository erUserRepository;
    private final GamesRepository gamesRepository;
    private final ErClient erClient;


    public Optional<ErUser> getNickname(ErUserForm erUserForm) {
        Optional<ErUser> erUserOptional = erUserRepository.findByNickname(erUserForm.getNickname());
        return erUserOptional;

    }

    public void saveNickname(ErUserForm erUserForm){

        String name = UriUtils.encodeQueryParam(erUserForm.getNickname(), StandardCharsets.UTF_8.toString());
        ErUserRequest request = ErUserRequest.builder()
                .query(name)
                .build();

        ErUserResponse erUserResponse = null;
        try {
            erUserResponse =  erClient.getUser(request);
        } catch (Exception e){
            throw new ErrorPageException("user guide page");
        }
        ErUserResponseInfo erUserResponseInfo = erUserResponse.getUser();

        log.info("{}", erUserResponse);

        ErUser erUser = ErUser.builder()
                .userNum(erUserResponseInfo.getUserNum())
                .nickname(erUserResponseInfo.getNickname())
                .build();

        erUserRepository.save(erUser);
    }

    /*public List<GameIdMapping> getGameId(ErUser erUser){
        List<GameIdMapping> gameIds = gamesRepository.findAll(erUser.getUserNum());
        return gameIds;
    }*/

    public void saveGameId(ErUserForm erUserForm){

        ErGameIdRequest request = ErGameIdRequest.builder()
                .userNum("1218167")
                .build();

        ErGameIdResponse erGameIdResponse = null;
        erGameIdResponse = erClient.getGameId(request);
        List<GameInfo> gameInfos = erGameIdResponse.getUserGames();

        for (GameInfo gameInfo: gameInfos) {
            Games game = Games.builder()
                    .gameId(gameInfo.getGameId())
                    .userNum(gameInfo.getUserNum())
                    .build();

            gamesRepository.save(game);

        }
    }

    /*public String getGameInfo(GameIdMapping gid){ //
        List<GameIdMapping> gameIds = gamesRepository.findAll(erUser.getUserNum());
        return gameIds;
    }*/

    public void saveGameInfo(String GameId){

        ErGameInfoRequest request = ErGameInfoRequest.builder()
                .gameId("16692574")
                .build();

        ErGameIdResponse erGameIdResponse = null;
        erGameIdResponse = erClient.getGameId(request);
        List<GameInfo> gameInfos = erGameIdResponse.getUserGames();

        for (GameInfo gameInfo: gameInfos) {
            Games game = Games.builder()
                    .gameId(gameInfo.getGameId())
                    .userNum(gameInfo.getUserNum())
                    .build();

            gamesRepository.save(game);

        }
    }

}
