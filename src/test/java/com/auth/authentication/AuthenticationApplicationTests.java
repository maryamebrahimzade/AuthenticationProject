package com.auth.authentication;

import com.auth.authentication.config.security.jwt.JwtService;
import com.auth.authentication.models.User;
import com.auth.authentication.repositories.UserRepository;
import com.auth.authentication.services.TokenService;
import com.auth.authentication.services.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;


@SpringBootTest
@Import(AuthenticationApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class AuthenticationApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtService jwtService;

    @Value("${jwt.token}")
    private String jwtToken;

    @Test
    void contextLoads() {
    }

    @BeforeAll
    public void init() {
        User user = User.builder()
                .username("maryam")
                .password("$2a$10$aHSBJUZKX2wCr3EQbYA8F.lHRu.Cgdy1TQc2wZblsm3q3ZYxOoUjK")
                .firstName("maryam")
                .lastName("ebrahimzade")
                .mobile("09127372713")
                .accountNumber("123456789123456789")
                .cardNumber("5859831045760950")
                .build();
        this.userRepository.save(user);
    }

    @Test
    public void givenUserList_whenFindAll_thenUsersList() {
        User user = User.builder()
                .username("zahra")
                .password("123Passwo&rd")
                .firstName("zahra")
                .lastName("ebrahimzade")
                .mobile("09127372713")
                .accountNumber("123456789123456789")
                .cardNumber("5859831045760950")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void givenUserObject_whenDeleteById_thenRemoveUser() {
        User user = User.builder()
                .username("asma")
                .password("123Passwo&rd")
                .firstName("asma")
                .lastName("ebrahimzade")
                .mobile("09127372713")
                .accountNumber("123456789123456789")
                .cardNumber("5859831045760950")
                .build();
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(1);
    }


    @Test
    public void givenToken_extractToken_thenGetUsername() {
        String username = jwtService.extractUsername(jwtToken);
        Assertions.assertThat(username).isEqualTo("maryam");
    }
}
