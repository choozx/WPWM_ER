package com.wpwm.er_wpwm.search;

import com.wpwm.er_wpwm.dto.ErUserForm;
import com.wpwm.er_wpwm.entity.ErUser;
import com.wpwm.er_wpwm.exception.ErrorPageException;
import com.wpwm.er_wpwm.repository.ErUserRepository;
import com.wpwm.er_wpwm.search.service.ErClient;
import com.wpwm.er_wpwm.search.service.model.ErRequest.ErUserRequest;
import com.wpwm.er_wpwm.search.service.model.ErResponse;
import com.wpwm.er_wpwm.search.service.model.ErResponse.ErUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ErService {

    private final ErUserRepository erUserRepository;
    private final ErClient erClient;


    public ErUser getNickname(ErUserForm erUserForm) {
        Optional<ErUser> erUserOptional = erUserRepository.findByNickname(erUserForm.getNickname());
        if (erUserOptional.isPresent()) {
            return erUserOptional.get();
        }

        String name = UriUtils.encodeQueryParam(erUserForm.getNickname(), StandardCharsets.UTF_8.toString());
        ErUserRequest request = ErUserRequest.builder()
                .query(name)
                .build();

        ErResponse erResponse = null;
        try {
            erResponse =  erClient.getUser(request);
        } catch (Exception e){
            throw new ErrorPageException("user guide page");
        }
        ErUserResponse erUserResponse = erResponse.getUser();

        log.info("{}", erResponse);

        ErUser erUser = ErUser.builder()
                .userNum(erUserResponse.getUserNum())
                .nickname(erUserResponse.getNickname())
                .build();

        return erUserRepository.save(erUser);
    }
}
