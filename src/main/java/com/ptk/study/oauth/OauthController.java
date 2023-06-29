package com.ptk.study.oauth;

import com.ptk.study.oauth.dto.KakaoTokenDTO;
import com.ptk.study.oauth.dto.OauthTokenRequestDTO;
import com.ptk.study.oauth.service.OauthService;
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

    public OauthService oauthService;

    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping
    public String getOauth(@RequestParam String code) {

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", "cd472dc23f994b84c4a4c252dd372b5b");
        body.add("redirect_uri", "http://221.162.209.84:8080/oauth");
        body.add("code", code);
        String token = oauthService.requestToken(body);
        String userProfile = oauthService.requestUserProfile(token);

        return userProfile;

    }

}
