package com.auth.authentication.services;

import com.auth.authentication.enums.Role;
import com.auth.authentication.exceptions.ServiceException;
import com.auth.authentication.config.security.jwt.JwtService;
import com.auth.authentication.dtos.LoginDto;
import com.auth.authentication.models.User;
import com.auth.authentication.utils.responses.AuthenticationResponse;
import com.auth.authentication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<UserRepository, User> {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;


    public ResponseEntity<User> register(User user) throws Exception {
        if (repository.existsByUsername(user.getUsername())) {
            throw new ServiceException("username-is-already-taken");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        repository.save(user);
        return ResponseEntity.ok(user);
    }

    public AuthenticationResponse login(LoginDto loginDto) throws Exception {
        authenticate(loginDto.getUsername(), loginDto.getPassword());
        var user = repository.findByUsername(loginDto.getUsername()).orElseThrow();
        final String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(token).user(user).build();
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new ServiceException(e, "user-disabled");
        } catch (BadCredentialsException e) {
            throw new ServiceException(e, "invalid-credentials");
        }
    }
}
