package com.wpwm.er_wpwm.includeModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@AllArgsConstructor
@Data
public class EquipmentInfo {
    private String weapon;
    private String chest;
    private String head;
    private String arm;
    private String leg;
    private String accessory;
}
