package com.wpwm.er_wpwm.search.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
public class ErRequest {

    @ToString
    @Getter
    @Builder
    public static class ErUserRequest{

        @JsonProperty("query")
        private String query;
    }
}