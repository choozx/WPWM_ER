package com.wpwm.er_wpwm.search.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ErResponse {

    @ToString
    @Getter
    public static class ErUserResponse{
        private int code;
        private String message;
        private ErUserResponseInfo user;

        @ToString
        @Getter
        public static class ErUserResponseInfo {

            @JsonProperty("userNum")
            private String userNum;
            @JsonProperty("nickname")
            private String nickname;
        }

    }

    @ToString
    @Getter
    public static class ErGameIdResponse{
        private int code;
        private String message;
        private List<GameInfo> userGames;

        @ToString
        @Getter
        public static class GameInfo {

            @JsonProperty("userNum")
            private String userNum;
            @JsonProperty("gameId")
            private String gameId;
        }
    }

}
