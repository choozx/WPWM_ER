package com.wpwm.er_wpwm.search.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ErResponse {

    private int code;
    private String message;
    private ErUserResponse user;

    @ToString
    @Getter
    public static class ErUserResponse {

        @JsonProperty("userNum")
        private String userNum;
        @JsonProperty("nickname")
        private String nickname;
    }
}
