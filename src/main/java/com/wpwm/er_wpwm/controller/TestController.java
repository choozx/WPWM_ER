package com.wpwm.er_wpwm.controller;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.search.ErService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private ErUserRepository erUserRepository;

    @Autowired
    private WebClient erWebClient;

    @Autowired
    private ErService erService;


    @PostMapping("/getNickname")
    public String asd(ErUserForm erUserForm) {
        String nickname = erUserForm.getNickname();
        erService.getNickname(erUserForm);


        //저장된 userNum으로 매치 찾기
        return "";
    }

    @GetMapping("/test3")
    public String test3() {

        String name = UriUtils.encodeQueryParam("쌍문동곡갱이", StandardCharsets.UTF_8.toString());
        System.out.println(name);
        return erWebClient.get()
                .uri(uriBuilder -> {
                    return uriBuilder
                            .path("v1/user/nickname")
                            .queryParam("query", name)
                            .build();
                })
                .headers(headers -> {
                    headers.add("x-api-key", apiKey);
                })
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

}
