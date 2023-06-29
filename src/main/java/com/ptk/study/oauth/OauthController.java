package com.ptk.study.oauth;

import com.ptk.study.oauth.dto.KakaoTokenDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/oauth")
public class OauthController {

    @GetMapping
    public String getOauth(@RequestParam String code) {
        String url = "https://kauth.kakao.com/oauth/token";
        RestTemplate restTemplate = new RestTemplate();

        // Header set
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Body set
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", "cd472dc23f994b84c4a4c252dd372b5b");
        body.add("redirect_uri", "http://localhost:8080/oauth");
        body.add("code", code);

        // Message
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        // Request
        HttpEntity<KakaoTokenDTO> response = restTemplate.postForEntity(url, requestMessage, KakaoTokenDTO.class);

        KakaoTokenDTO kakaoTokenDTO = response.getBody();

        return kakaoTokenDTO.getAccess_token();

    }

}
