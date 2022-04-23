package com.wpwm.er_wpwm.includeModel.player;

import com.wpwm.er_wpwm.includeModel.player.element.EquipmentInfo;
import com.wpwm.er_wpwm.includeModel.player.element.MasteryInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlayerInfo {

    private String userNum;
    private String nickname;
    private String gameId;
    private String seasonId;
    private String matchingMode;
    private String matchingTeamMode;
    private String characterNum;
    private String skinCode;
    private String characterLevel;
    private String gameRank;
    private String playerKill;
    private String playerAssistant;
    private String monsterKill;
    private String bestWeapon;
    private String bestWeaponLevel;
    private String versionMajor;
    private String versionMinor;
    private String language;
    private EquipmentInfo equipmentInfo;
    private MasteryInfo masteryInfo;
}
