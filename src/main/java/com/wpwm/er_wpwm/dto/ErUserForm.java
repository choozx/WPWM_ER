package com.wpwm.er_wpwm.dto;

import lombok.Getter;

@Getter
public class ErUserForm {

    private String nickname;

    public ErUserForm(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "ErUserForm{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
