package com.wpwm.er_wpwm.entity;

import com.wpwm.er_wpwm.type.EquipmentType;
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
    @Column(name="equipment")
    @Enumerated(EnumType.STRING)
    private EquipmentType equipment;
    @Column(name = "code")
    private int code;

}
