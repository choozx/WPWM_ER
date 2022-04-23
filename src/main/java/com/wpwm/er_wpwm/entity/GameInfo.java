package com.wpwm.er_wpwm.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GameInfo")
public class GameInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="userNum")
    private String userNum;
    @Column(name="nickname")
    private String nickname;
    @Column(name="gameId")
    private String gameId;
    @Column(name="seasonId")
    private String seasonId;
    @Column(name="matchingMode")
    private String matchingMode;
    @Column(name="matchingTeamMode")
    private String matchingTeamMode;
    @Column(name="characterNum")
    private String characterNum;
    @Column(name="skinCode")
    private String skinCode;
    @Column(name="characterLevel")
    private String characterLevel;
    @Column(name="gameRank")
    private String gameRank;
    @Column(name="playerKill")
    private String playerKill;
    @Column(name="playerAssistant")
    private String playerAssistant;
    @Column(name="monsterKill")
    private String monsterKill;
    @Column(name="bestWeapon")
    private String bestWeapon;
    @Column(name="bestWeaponLevel")
    private String bestWeaponLevel;
    @Column(name="versionMajor")
    private String versionMajor;
    @Column(name="versionMinor")
    private String versionMinor;
    @Column(name="language")
    private String language;
    //@Column(name="skillLevelInfo")   <-생각좀 해봐야됨 찍는 스킬은 6~7개 (q,w,e,r,패시브,무기스킬 + 아이템스킬) 전부 넣긴해야되는데 칼럼이 너무 많음
    //private SkillLevelInfo skillLevelInfo;
    //@Column(name="skillOrderInfo")  <- 이것도 생각해봐야됨 위에보단 금방 생각 날듯
    //private SkillOrderInfo skillOrderInfo;





}
