package com.wpwm.er_wpwm.includeModel;

import com.wpwm.er_wpwm.includeModel.player.PlayerInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Participant {
    private List<PlayerInfo> playerInfos;
}
