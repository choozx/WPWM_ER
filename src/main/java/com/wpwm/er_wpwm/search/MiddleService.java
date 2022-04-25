package com.wpwm.er_wpwm.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.entity.GameIds;
import com.wpwm.er_wpwm.entity.MasteryLevel;
import com.wpwm.er_wpwm.entity.Player;
import com.wpwm.er_wpwm.exception.ErrorPageException;
import com.wpwm.er_wpwm.includeModel.UserInfo;
import com.wpwm.er_wpwm.includeModel.GameId;
import com.wpwm.er_wpwm.includeModel.player.PlayerInfo;
import com.wpwm.er_wpwm.includeModel.player.element.EquipmentInfo;
import com.wpwm.er_wpwm.includeModel.player.element.MasteryInfo;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.repository.GamesRepository;
import com.wpwm.er_wpwm.repository.MasteryRepository;
import com.wpwm.er_wpwm.repository.PlayerRepository;
import com.wpwm.er_wpwm.search.client.ErClient;
import com.wpwm.er_wpwm.search.client.model.ErRequest.ErGameInfoRequest;
import com.wpwm.er_wpwm.search.client.model.ErRequest.ErGameIdRequest;
import com.wpwm.er_wpwm.search.client.model.ErRequest.ErUserRequest;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErGameInfoResponse;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErGameInfoResponse.Participant;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErGameIdResponse;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErUserResponse;
import com.wpwm.er_wpwm.search.client.model.ErResponse.ErUserResponse.ErUserResponseInfo;
import com.wpwm.er_wpwm.type.MasteryType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MiddleService {

    private final ErUserRepository erUserRepository;
    private final GamesRepository gamesRepository;
    private final PlayerRepository playerRepository;
    private final MasteryRepository masteryRepository;
    private final ErClient erClient;

    private final ObjectMapper objectMapper;


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

    public List<GameId> getGameIdFromDB(UserInfo userInfo) { //entity에서 객체로 옮기는 작업
        List<GameIds> gameIds = gamesRepository.findByUserNum(userInfo.getUserNum());
        List<GameId> gameIdList = null;
        for (GameIds game: gameIds) {
            GameId gameId = GameId.builder()
                    .userNum(game.getUserNum())
                    .gameId(game.getGameId())
                    .build();
            gameIdList.add(gameId);
        }
        return gameIdList;
    }


    public List<GameId> saveGameIdFromClient(UserInfo userInfo) {


        List<GameId> newGameId = null;
        Optional<GameIds> lastGamesOpt = getLastGames(userInfo.getUserNum());
        int savePolicy = lastGamesOpt.isEmpty() ? 16700000 : lastGamesOpt.get().getGameId();


        ErGameIdResponse response = erClient.getGameId(userInfo.getUserNum());

        while (!response.getUserGames().isEmpty()) {
            List<GameIds> gamesList = response.getUserGames().stream()
                    .map(gameId ->
                            GameIds.builder()
                                    .gameId(gameId.getGameId())
                                    .userNum(gameId.getUserNum())
                                    .build()
                    )
                    .filter(gameId -> gameId.getGameId() > savePolicy)
                    .collect(Collectors.toList());

            newGameId.addAll(
                    response.getUserGames().stream()
                            .map(gameId ->
                                    GameId.builder()
                                            .gameId(gameId.getGameId())
                                            .userNum(gameId.getUserNum())
                                            .build()
                            )
                            .filter(gameId -> gameId.getGameId() > savePolicy)
                            .collect(Collectors.toList())
            );
            gamesRepository.saveAll(gamesList);

            if (gamesList.size() != 10) {
                break;
            }

            int oldestGameId = gamesList.get(gamesList.size() - 1).getGameId();
            response = erClient.getGameId(userInfo.getUserNum(), ErGameIdRequest.builder().next(oldestGameId).build());
        }
        return newGameId;
    }

    public void saveGameInfoFromClient(GameId gameId) {

        ErGameInfoResponse response = erClient.getGameInfo("16692574");
        for (Participant participant: response.getUserGames()) {

            System.out.println(participant.getMasteryLevel());
            Player player = Player.builder()
                    .gameId(participant.getGameId())
                    .userNum(participant.getUserNum())
                    .nickname(participant.getNickname())
                    .seasonId(participant.getSeasonId())
                    .matchingMode(participant.getMatchingMode())
                    .matchingTeamMode(participant.getMatchingTeamMode())
                    .characterNum(participant.getCharacterNum())
                    .skinCode(participant.getSkinCode())
                    .characterLevel(participant.getCharacterLevel())
                    .gameRank(participant.getGameRank())
                    .playerKill(participant.getPlayerKill())
                    .playerAssistant(participant.getPlayerAssistant())
                    .monsterKill(participant.getMonsterKill())
                    .bestWeapon(participant.getBestWeapon())
                    .bestWeaponLevel(participant.getBestWeaponLevel())
                    .versionMajor(participant.getVersionMajor())
                    .versionMinor(participant.getVersionMinor())
                    .language(participant.getLanguage())
                    .build();


            Participant.MasteryLevel masteryLevel = participant.getMasteryLevel();

            List<MasteryLevel> masteryLevelList = new ArrayList<>();
            Map<String, String> masteryLevelMap = objectMapper.convertValue(masteryLevel, Map.class);
//            objectMapper.writeValueAsString(participant.getMasteryLevel());
            for (Map.Entry<String, String> entry : masteryLevelMap.entrySet()) {
                MasteryType masteryType = MasteryType.of(Integer.parseInt(entry.getKey()));
                int level = Integer.parseInt(entry.getValue());

                masteryLevelList.add(MasteryLevel.builder()
                        .gameId(gameId.getGameId())
                        .userNum(gameId.getUserNum())
                        .mastery(masteryType)
                        .level(level)
                        .build()
                );
            }

            masteryRepository.saveAll(masteryLevelList);
        }
    }

    public List<PlayerInfo> getPlayerFromDB(GameId gameId) {
        List<PlayerInfo> playerInfoList = null;
        List<Player> players = playerRepository.findByGameId(gameId.getGameId());
        for (Player player:players) {
            //마스터리랑 장비 객체 불러오기
//            MasteryInfo masteryInfo = getMasteryLevel(gameId);
//            EquipmentInfo equipmentInfo = getEquipment(gameId);

            PlayerInfo playerInfo = PlayerInfo.builder()
                    .gameId(player.getGameId())
                    .userNum(player.getUserNum())
                    .nickname(player.getNickname())
                    .seasonId(player.getSeasonId())
                    .matchingMode(player.getMatchingMode())
                    .matchingTeamMode(player.getMatchingTeamMode())
                    .characterNum(player.getCharacterNum())
                    .skinCode(player.getSkinCode())
                    .characterLevel(player.getCharacterLevel())
                    .gameRank(player.getGameRank())
                    .playerKill(player.getPlayerKill())
                    .playerAssistant(player.getPlayerAssistant())
                    .monsterKill(player.getMonsterKill())
                    .bestWeapon(player.getBestWeapon())
                    .bestWeaponLevel(player.getBestWeaponLevel())
                    .versionMajor(player.getVersionMajor())
                    .versionMinor(player.getVersionMinor())
                    .language(player.getLanguage())
//                    .masteryInfo(masteryInfo)
//                    .equipmentInfo(equipmentInfo)
                    .build();

            playerInfoList.add(playerInfo);
        }

        return playerInfoList;
    }

    public void savePlayerFromClient(GameId gameId){

    }

//    public String getGameInfo(GameIdMapping info){ //
//        List<GameIdMapping> gameIds = gamesRepository.findAll(erUser.getUserNum());
//        return gameIds;
//    }

    /*public void saveGameInfo(String GameId){

        ErGameInfoRequest request = ErGameInfoRequest.builder()
                .gameId("16692574")
                .build();

        ErGameInfoResponse erGameInfoResponse = null;
        erGameInfoResponse = erClient.getGameId(request);

        List<player> gameInfo = erGameInfoResponse.getPlayers();

    }*/

    private Optional<GameIds> getLastGames(String userNum) {
        return gamesRepository.findTopByUserNumOrderByGameIdDesc(userNum);
    }

    /*private MasteryInfo getMasteryLevel(GameId gameId) {
        List<MasteryLevel> masteryLevels = masteryRepository.findByGameIdAndUserNum(gameId.getGameId(), gameId.getUserNum());

        return ;
    }

    private EquipmentInfo getEquipment(GameId gameId) {

        return ;
    }*/

}
