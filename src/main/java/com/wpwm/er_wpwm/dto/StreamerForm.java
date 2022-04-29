package com.wpwm.er_wpwm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@Builder
@ToString
public class StreamerForm {

    private String erNickname;
    private String twitchId;

}
