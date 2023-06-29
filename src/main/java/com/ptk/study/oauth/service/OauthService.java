package com.ptk.study.oauth.service;

import org.springframework.util.MultiValueMap;

public interface OauthService {
    String requestToken(MultiValueMap<String, String> body);
    String requestUserProfile(String token);
}
