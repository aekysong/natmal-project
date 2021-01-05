package com.toy.aeky.natmal.common.auth;

import com.toy.aeky.natmal.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class JwtTokenProvider {

    private String secretKey;
    private Long validTime = 3000L * 60 * 60; //3시간
    private final UserService userService;

    public String generateToken(String tokenType, Claims claims) {
        return Jwts.builder()
                .setSubject(tokenType)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .compact();
    }
}
