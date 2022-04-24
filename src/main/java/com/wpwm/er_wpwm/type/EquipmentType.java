package com.wpwm.er_wpwm.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EquipmentType {

    WEAPON(0),
    CHEST(1),
    HEAD(2),
    ARM(3),
    LEG(4),
    ACCESSORY(5)

    ;

    private int code;

    public static EquipmentType of(int code){
        for (EquipmentType value : EquipmentType.values()) {
            if(value.getCode()==code){
                return value;
            }
        }
        throw new RuntimeException("not found mastery type");
    }

}
