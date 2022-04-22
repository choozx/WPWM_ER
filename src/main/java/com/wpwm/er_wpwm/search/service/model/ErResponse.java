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
        private List<GameId> userGames;
        private int next;

        @ToString
        @Getter
        public static class GameId {

            @JsonProperty("userNum")
            private String userNum;
            @JsonProperty("gameId")
            private int gameId;
        }
    }

    @ToString
    @Getter
    public static class ErGameInfoResponse{
        private int code;
        private String message;
        private List<player> players;

        @ToString
        @Getter
        public static class player {

            @JsonProperty("userNum")
            private String userNum;
            @JsonProperty("nickname")
            private String nickname;
            @JsonProperty("gameId")
            private String gameId;
            @JsonProperty("seasonId")
            private String seasonId;
            @JsonProperty("matchingMode")
            private String matchingMode;
            @JsonProperty("matchingTeamMode")
            private String matchingTeamMode;
            @JsonProperty("characterNum")
            private String characterNum;
            @JsonProperty("skinCode")
            private String skinCode;
            @JsonProperty("characterLevel")
            private String characterLevel;
            @JsonProperty("gameRank")
            private String gameRank;
            @JsonProperty("playerKill")
            private String playerKill;
            @JsonProperty("playerAssistant")
            private String playerAssistant;
            @JsonProperty("monsterKill")
            private String monsterKill;
            @JsonProperty("bestWeapon")
            private String bestWeapon;
            @JsonProperty("bestWeaponLevel")
            private String bestWeaponLevel;
            @JsonProperty("masteryLevel")
            private MasteryLevel masteryLevel;
            @JsonProperty("equipment")
            private Equipment equipment;
            @JsonProperty("versionMajor")
            private String versionMajor;
            @JsonProperty("versionMinor")
            private String versionMinor;
            @JsonProperty("language")
            private String language;
            //@JsonProperty("skillLevelInfo")   <-생각좀 해봐야됨 찍는 스킬은 6~7개 (q,w,e,r,패시브,무기스킬 + 아이템스킬) 전부 넣긴해야되는데 칼럼이 너무 많음
            //private SkillLevelInfo skillLevelInfo;
            //@JsonProperty("skillOrderInfo")  <- 이것도 생각해봐야됨 위에보단 금방 생각 날듯
            //private SkillOrderInfo skillOrderInfo;




            public static class SkillOrderInfo {

            }


            public static class Equipment {
                @JsonProperty("0")
                private String weapon;
                @JsonProperty("1")
                private String chest;
                @JsonProperty("2")
                private String head;
                @JsonProperty("3")
                private String arm;
                @JsonProperty("4")
                private String leg;
                @JsonProperty("5")
                private String accessory;


            }

            public static class MasteryLevel {

                @JsonProperty("1")
                private String gloveMastery;
                @JsonProperty("2")
                private String tonfaMastery;
                @JsonProperty("3")
                private String batMastery;
                @JsonProperty("4")
                private String whipMastery;
                @JsonProperty("5")
                private String throwMastery;
                @JsonProperty("6")
                private String shurikenMastery;
                @JsonProperty("7")
                private String bowMastery;
                @JsonProperty("8")
                private String crossBowMastery;
                @JsonProperty("9")
                private String pistolMastery;
                @JsonProperty("10")
                private String assaultRifleMastery;
                @JsonProperty("11")
                private String sniperRifleMastery;
                @JsonProperty("13")
                private String hammerMastery;
                @JsonProperty("14")
                private String axeMastery;
                @JsonProperty("15")
                private String daggerMastery;
                @JsonProperty("16")
                private String twoHandSwordMastery;
                @JsonProperty("18")
                private String dualSwordMastery;
                @JsonProperty("19")
                private String spearMastery;
                @JsonProperty("20")
                private String nunchakuMastery;
                @JsonProperty("21")
                private String rapierMastery;
                @JsonProperty("22")
                private String guitarMastery;
                @JsonProperty("23")
                private String cameraMastery;
                @JsonProperty("24")
                private String arcanaMastery;
                @JsonProperty("25")
                private String vfArmMastery;




                @JsonProperty("101")
                private String trapMastery;
                @JsonProperty("102")
                private String craftMastery;
                @JsonProperty("103")
                private String searchMastery;
                @JsonProperty("104")
                private String moveMastery;
                @JsonProperty("201")
                private String healthMastery;
                @JsonProperty("202")
                private String defenseMastery;
                @JsonProperty("204")
                private String huntMastery;

            }

        }
    }

}
