package com.ptk.study.oauth.service;

import com.ptk.study.oauth.dto.KakaoTokenDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OauthTokenServiceImple implements OauthTokenService{
    public String requestToken(MultiValueMap<String, String> body) {



        // Header set
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        String url = "https://kauth.kakao.com/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<KakaoTokenDTO> response = restTemplate.postForEntity(url, requestMessage, KakaoTokenDTO.class);
        return response.getBody().getAccess_token();
    }
}
