package com.wpwm.er_wpwm.includeModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserInfo {
    private String userNum;
    private String nickName;
}
