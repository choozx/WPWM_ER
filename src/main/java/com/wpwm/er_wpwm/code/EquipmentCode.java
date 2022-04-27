package com.wpwm.er_wpwm.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EquipmentCode {

    WEAPON(0),
    CHEST(1),
    HEAD(2),
    ARM(3),
    LEG(4),
    ACCESSORY(5)

    ;

    private int code;

    public static EquipmentCode of(int code){
        for (EquipmentCode value : EquipmentCode.values()) {
            if(value.getCode()==code){
                return value;
            }
        }
        throw new RuntimeException("not found mastery type");
    }

}
