package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IntegrationTest {
    @Test
    void testSuccessfulRegisterUser(){
        ClassUserRepository mock_userRepository = mock(ClassUserRepository.class);
        when(mock_userRepository.isEmailExistsInDatabase("qwe@gmail.com")).thenReturn(false);
        UserService userService = new UserService(mock_userRepository);

        String message = userService.registerUser("qwe@gmail.com","12345678");
        assertTrue(message.contains("successfully registered"));
    }

}
