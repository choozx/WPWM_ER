package com.wpwm.er_wpwm.search.service;

import com.wpwm.er_wpwm.client.Client;
import com.wpwm.er_wpwm.client.util.QueryParamsConverter;
import com.wpwm.er_wpwm.search.service.model.ErRequest;
import com.wpwm.er_wpwm.search.service.model.ErRequest.ErGameIdRequest;
import com.wpwm.er_wpwm.search.service.model.ErRequest.ErUserRequest;
import com.wpwm.er_wpwm.search.service.model.ErResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErGameInfoResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErGameIdResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ErClient extends Client {

    @Value("${api.key}")
    private String apiKey;

    public ErClient(WebClient webClient, QueryParamsConverter queryParamsConverter) {
        super(webClient, queryParamsConverter);
    }

    public ErUserResponse getUser(ErUserRequest request){
        sleep();
        return get("v1/user/nickname", request, ErUserResponse.class, makeHeaders());
    }

    public ErGameIdResponse getGameId(String userNum){
        sleep();
        return get("v1/user/games/" + userNum, ErGameIdResponse.class, makeHeaders());
    }

    public ErGameIdResponse getGameId(String userNum,ErGameIdRequest request){
        sleep();
        return get("v1/user/games/" + userNum, request, ErGameIdResponse.class, makeHeaders());
    }

    public ErGameInfoResponse getGameInfo(ErGameIdRequest request){
        sleep();
        return get("v1/user/games/", ErGameInfoResponse.class, makeHeaders());
    }

    private HttpHeaders makeHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", apiKey);
        return headers;
    }

    private void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
