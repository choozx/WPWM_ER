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
public class Streamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userNum")
    private String userNum;
    @Column(name = "nickName")
    private String nickName;
    @Column(name = "twitchId")
    private String twitchId;

}
