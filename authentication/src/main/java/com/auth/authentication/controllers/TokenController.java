package com.auth.authentication.controllers;

import com.auth.authentication.utils.responses.TokenValidityResponse;
import com.auth.authentication.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/token")
public class TokenController {
    @Autowired
    private TokenService service;

    @GetMapping("/is-valid")
    public TokenValidityResponse isTokenValid(@RequestHeader(name = "Authorization") String token) throws Exception {
        return service.isTokenValid(token);
    }
}
