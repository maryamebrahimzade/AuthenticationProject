package com.auth.authentication.controllers;

import com.auth.authentication.dtos.LoginDto;
import com.auth.authentication.dtos.UserDto;
import com.auth.authentication.models.User;
import com.auth.authentication.utils.responses.AuthenticationResponse;
import com.auth.authentication.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController<User, UserDto, UserService> {
    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@Validated @RequestBody UserDto dto) throws Exception {
        return ResponseEntity.ok(service.register(mapper.mapDto(dto)));
    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginDto loginDto) throws Exception {
        return ResponseEntity.ok(service.login(loginDto));
    }
}
