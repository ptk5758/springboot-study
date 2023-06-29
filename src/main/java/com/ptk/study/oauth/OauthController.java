package com.ptk.study.oauth;

import com.ptk.study.oauth.dto.KakaoTokenDTO;
import com.ptk.study.oauth.dto.OauthTokenRequestDTO;
import com.ptk.study.oauth.service.OauthTokenService;
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

    public OauthTokenService oauthTokenService;

    public OauthController(OauthTokenService oauthTokenService) {
        this.oauthTokenService = oauthTokenService;
    }

    @GetMapping
    public String getOauth(@RequestParam String code) {

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", "cd472dc23f994b84c4a4c252dd372b5b");
        body.add("redirect_uri", "http://localhost:8080/oauth");
        body.add("code", code);

        return oauthTokenService.requestToken(body);

    }

}
