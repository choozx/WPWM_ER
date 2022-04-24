package com.wpwm.er_wpwm.entity;

import com.wpwm.er_wpwm.type.MasteryType;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MasteryLevel")
public class MasteryLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "gameId")
    private String gameId;
    @Column(name = "userNum")
    private String userNum;
    @Column(name = "mastery")
    @Enumerated(EnumType.STRING)
    private MasteryType mastery;
    @Column(name="level")
    private int level;

}
