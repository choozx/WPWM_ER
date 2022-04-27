package com.wpwm.er_wpwm.search.client.model;

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

    @ToString
    @Getter
    @Builder
    public static class ErGameIdRequest{

        @JsonProperty("next")
        private int next;
    }

    @ToString
    @Getter
    @Builder
    public static class ErGameInfoRequest{

        private String gameId;
    }
}
