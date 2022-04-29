package com.wpwm.er_wpwm.includeModel.player.element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class MasteryInfo {

    private HashMap<String, Integer> masteryMap;

}
