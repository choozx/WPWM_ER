package com.wpwm.er_wpwm.includeModel.player.element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class MasteryInfo {
    private String gloveMastery;
    private String tonfaMastery;
    private String batMastery;
    private String whipMastery;
    private String throwMastery;
    private String shurikenMastery;
    private String bowMastery;
    private String crossBowMastery;
    private String pistolMastery;
    private String assaultRifleMastery;
    private String sniperRifleMastery;
    private String hammerMastery;
    private String axeMastery;
    private String daggerMastery;
    private String twoHandSwordMastery;
    private String dualSwordMastery;
    private String spearMastery;
    private String nunchakuMastery;
    private String rapierMastery;
    private String guitarMastery;
    private String cameraMastery;
    private String arcanaMastery;
    private String vfArmMastery;


    private String trapMastery;
    private String craftMastery;
    private String searchMastery;
    private String moveMastery;
    private String healthMastery;
    private String defenseMastery;
    private String huntMastery;
}
