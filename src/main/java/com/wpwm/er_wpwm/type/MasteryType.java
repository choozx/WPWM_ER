package com.wpwm.er_wpwm.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MasteryType {


    GLOVE(1),
    TONFA(2),
    BAT(3),
    WHIP(4),
    THROW(5),
    SHURIKEN(6),
    BOW(7),
    CROSSBOW(8),
    PISTOL(9),
    ASSAULTRIFLE(10),
    SNIPERRIFLE(11),
    HAMMER(13),
    AXE(14),
    DAGGER(15),
    TWOHANDSWORD(16),
    DUALSWORD(18),
    SPEAR(19),
    NUNCHAKU(20),
    RAPIER(21),
    GUITAR(22),
    CAMERA(23),
    ARCANA(24),
    VFARM(25),
    TRAP(101),
    CRAFT(102),
    SEARCH(103),
    MOVE(104),
    HEALTH(201),
    DEFENSE(202),
    HUNT(204),

    ;

    private int code;

    public static MasteryType of(int code){
        for (MasteryType value : MasteryType.values()) {
            if(value.getCode()==code){
                return value;
            }
        }
        throw new RuntimeException("not found mastery type");
    }



}
