package com.wpwm.er_wpwm.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gameId")
    private String gameId;
    @Column(name = "userNum")
    private String userNum;

    @Column(name="weapon")
    private String weapon;
    @Column(name="chest")
    private String chest;
    @Column(name="head")
    private String head;
    @Column(name="arm")
    private String arm;
    @Column(name="leg")
    private String leg;
    @Column(name="accessory")
    private String accessory;

}
