package com.wpwm.er_wpwm.includeModel;

import com.wpwm.er_wpwm.includeModel.player.PlayerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserAllInfo {
    private List<PlayerInfo> gameInfo;
    private UserInfo userInfo;
}
