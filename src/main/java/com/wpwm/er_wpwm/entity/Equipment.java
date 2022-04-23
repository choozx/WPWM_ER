package com.wpwm.er_wpwm.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ErUser")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gameId")
    private String nickname;
    @Column(name = "userNum")
    private String userNum;

    @Column(name="0")
    private String weapon;
    @Column(name="1")
    private String chest;
    @Column(name="2")
    private String head;
    @Column(name="3")
    private String arm;
    @Column(name="4")
    private String leg;
    @Column(name="5")
    private String accessory;

}
