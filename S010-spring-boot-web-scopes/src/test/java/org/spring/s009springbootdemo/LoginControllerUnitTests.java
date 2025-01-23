package org.spring.s009springbootdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.spring.s009springbootdemo.controllers.LoginController;
import org.spring.s009springbootdemo.processors.LoginProcessor;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {
    @Mock
    private LoginProcessor loginProcessor;

    @Mock
    Model model;

    @InjectMocks
    private LoginController loginController;

    @Test
    @DisplayName("Test login controller happy flow")
    public void loginControllerHappyFlow(){
        Mockito.when(loginProcessor.login()).thenReturn(true);
        String result = loginController.loginPost("acdevs", "4444", model);
        Assertions.assertEquals("redirect:/", result);
        Mockito.verify(model).addAttribute("message", "You are logged in");
    }

    @Test
    @DisplayName("Test login controller sad flow")
    public void loginControllerSadFlow(){
        Mockito.when(loginProcessor.login()).thenReturn(false);
        String result = loginController.loginPost("acdevs", "4444", model);
        Assertions.assertEquals("login.html", result);
    }
}
