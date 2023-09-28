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
                .username("arezooalipanah")
                .password("$2a$10$f7M0SWWUJ8RSpLRDDpw1S.RoBWLBkVTDzz/bJpgmjdl39EyK1mGnK")
                .firstName("arezoo")
                .lastName("alipanah")
                .mobile("09195529919")
                .accountNumber("636214105672306558")
                .cardNumber("6362141056723068")
                .build();
        this.userRepository.save(user);
    }

    @Test
    public void givenUserList_whenFindAll_thenUsersList() {
        User user = User.builder()
                .username("user2")
                .password("22209318")
                .firstName("arezoo2")
                .lastName("alipanah2")
                .mobile("0127292561")
                .accountNumber("636214105672306558")
                .cardNumber("6362141056723068")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void givenUserObject_whenDeleteById_thenRemoveUser() {
        User user = User.builder()
                .username("user3")
                .password("22209318")
                .firstName("arezoo3")
                .lastName("alipanah")
                .mobile("0127292561")
                .accountNumber("636214105672306558")
                .cardNumber("6362141056723068")
                .build();
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(1);
    }


    @Test
    public void givenToken_extractToken_thenGetUsername() {
        String username = jwtService.extractUsername(jwtToken);
        Assertions.assertThat(username).isEqualTo("arezooalipanah");
    }
}
