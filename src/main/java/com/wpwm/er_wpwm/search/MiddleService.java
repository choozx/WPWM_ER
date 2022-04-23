package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.Games;
import com.wpwm.er_wpwm.exception.ErrorPageException;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.repository.GamesRepository;
import com.wpwm.er_wpwm.search.client.ErClient;
import com.wpwm.er_wpwm.search.client.model.ErRequest.ErGameIdRequest;
import com.wpwm.er_wpwm.search.client.model.ErRequest.ErUserRequest;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErGameIdResponse;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErUserResponse;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErUserResponse.ErUserResponseInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MiddleService {

    private final ErUserRepository erUserRepository;
    private final GamesRepository gamesRepository;
    private final ErClient erClient;


    public Optional<ErUser> getUserFromDB(ErUserForm erUserForm) {
        Optional<ErUser> erUserOptional = erUserRepository.findByNickName(erUserForm.getNickname());
        return erUserOptional;

    }

    public void saveUserFromClient(ErUserForm erUserForm) {

        String name = UriUtils.encodeQueryParam(erUserForm.getNickname(), StandardCharsets.UTF_8.toString());
        ErUserRequest request = ErUserRequest.builder()
                .query(name)
                .build();

        ErUserResponse erUserResponse = null;
        try {
            erUserResponse = erClient.getUser(request);
        } catch (Exception e) {
            throw new ErrorPageException("user guide page");
        }
        ErUserResponseInfo erUserResponseInfo = erUserResponse.getUser();

        log.info("{}", erUserResponse);

        ErUser erUser = ErUser.builder()
                .userNum(erUserResponseInfo.getUserNum())
                .nickName(erUserResponseInfo.getNickname())
                .build();

        erUserRepository.save(erUser);
    }

    public List<Games> getGameId(ErUser erUser) {
        List<Games> gameIds = gamesRepository.findByUserNum(erUser.getUserNum());
        return gameIds;
    }


    public void saveGameId(ErUserForm erUserForm) {

        erUserForm.setUserNum("1218167");

        Optional<Games> lastGamesOpt = getLastGames(erUserForm.getUserNum());
        int savePolicy = lastGamesOpt.isEmpty() ? 16700000 : lastGamesOpt.get().getGameId();


        ErGameIdResponse response = erClient.getGameId(erUserForm.getUserNum());

        while (!response.getUserGames().isEmpty()) {
            List<Games> gamesList = response.getUserGames().stream()
                    .map(gameId ->
                            Games.builder()
                                    .gameId(gameId.getGameId())
                                    .userNum(gameId.getUserNum())
                                    .build()
                    )
                    .filter(gameId -> gameId.getGameId() > savePolicy)
                    .collect(Collectors.toList());

            gamesRepository.saveAll(gamesList);

            if (gamesList.size() != 10) {
                break;
            }

            int oldestGameId = gamesList.get(gamesList.size() - 1).getGameId();
            response = erClient.getGameId(erUserForm.getUserNum(), ErGameIdRequest.builder().next(oldestGameId).build());
        }
    }

    /*public String getGameInfo(GameIdMapping info){ //
        List<GameIdMapping> gameIds = gamesRepository.findAll(erUser.getUserNum());
        return gameIds;
    }*/

    /*public void saveGameInfo(String GameId){

        ErGameInfoRequest request = ErGameInfoRequest.builder()
                .gameId("16692574")
                .build();

        ErGameInfoResponse erGameInfoResponse = null;
        erGameInfoResponse = erClient.getGameId(request);

        List<player> gameInfo = erGameInfoResponse.getPlayers();

    }*/

    private Optional<Games> getLastGames(String userNum) {
        return gamesRepository.findTopByUserNumOrderByGameIdDesc(userNum);
    }

}
