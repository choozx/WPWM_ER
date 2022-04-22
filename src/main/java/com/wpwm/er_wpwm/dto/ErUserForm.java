package com.wpwm.er_wpwm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Builder
public class ErUserForm {

    private String nickname;
    private String userNum;

    @Override
    public String toString() {
        return "ErUserForm{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
