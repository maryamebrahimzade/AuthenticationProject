package com.auth.authentication.config.handler;

import com.auth.authentication.config.cache.RedisService;
import com.auth.authentication.config.security.jwt.JwtService;
import com.auth.authentication.utils.ExtractRequestHeader;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CustomLogoutHandler implements LogoutHandler {
    private final RedisService redisService;
    private final JwtService jwtService;
    @Value("${jwt.token.id.validity}")
    private long JWT_ID_VALIDITY;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        redisService.set(
                jwtService.extractId(ExtractRequestHeader.getHeaderPureToken(request)),
                true,
                JWT_ID_VALIDITY,
                TimeUnit.SECONDS
        );
    }
}
