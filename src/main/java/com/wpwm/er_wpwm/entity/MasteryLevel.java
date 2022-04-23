package com.wpwm.er_wpwm.entity;

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

    @Column(name="1")
    private String gloveMastery;
    @Column(name="2")
    private String tonfaMastery;
    @Column(name="3")
    private String batMastery;
    @Column(name="4")
    private String whipMastery;
    @Column(name="5")
    private String throwMastery;
    @Column(name="6")
    private String shurikenMastery;
    @Column(name="7")
    private String bowMastery;
    @Column(name="8")
    private String crossBowMastery;
    @Column(name="9")
    private String pistolMastery;
    @Column(name="10")
    private String assaultRifleMastery;
    @Column(name="11")
    private String sniperRifleMastery;
    @Column(name="13")
    private String hammerMastery;
    @Column(name="14")
    private String axeMastery;
    @Column(name="15")
    private String daggerMastery;
    @Column(name="16")
    private String twoHandSwordMastery;
    @Column(name="18")
    private String dualSwordMastery;
    @Column(name="19")
    private String spearMastery;
    @Column(name="20")
    private String nunchakuMastery;
    @Column(name="21")
    private String rapierMastery;
    @Column(name="22")
    private String guitarMastery;
    @Column(name="23")
    private String cameraMastery;
    @Column(name="24")
    private String arcanaMastery;
    @Column(name="25")
    private String vfArmMastery;




    @Column(name="101")
    private String trapMastery;
    @Column(name="102")
    private String craftMastery;
    @Column(name="103")
    private String searchMastery;
    @Column(name="104")
    private String moveMastery;
    @Column(name="201")
    private String healthMastery;
    @Column(name="202")
    private String defenseMastery;
    @Column(name="204")
    private String huntMastery;


}
