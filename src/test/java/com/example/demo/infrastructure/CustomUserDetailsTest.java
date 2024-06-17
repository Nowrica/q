package com.example.demo.infrastructure;

import com.example.demo.application.port.out.UserRepository;
import org.junit.jupiter.api.Test;

class CustomUserDetailsTest {

    @Test
    void UserName으로_User를_조회할_수_있다() {

        // given
        UserRepository userRepository = new FakeUserRepository();
        CustomUserDetails customUserDetails = new CustomUserDetails();

    }
}