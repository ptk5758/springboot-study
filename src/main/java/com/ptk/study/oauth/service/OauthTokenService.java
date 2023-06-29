package com.ptk.study.oauth.service;

import org.springframework.util.MultiValueMap;

public interface OauthTokenService {
    String requestToken(MultiValueMap<String, String> body);
}
