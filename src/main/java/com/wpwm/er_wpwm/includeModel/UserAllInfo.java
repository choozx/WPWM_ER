package com.wpwm.er_wpwm.includeModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserAllInfo {
    private List<GameInfo> gameInfo;
    private UserInfo userInfo;
}
