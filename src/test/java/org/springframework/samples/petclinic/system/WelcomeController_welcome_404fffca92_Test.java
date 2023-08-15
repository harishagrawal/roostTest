package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
}

class WelcomeController_welcome_404fffca92_Test {

    @InjectMocks
    private WelcomeController welcomeController;

    @BeforeEach
    public void init() {
        welcomeController = new WelcomeController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWelcome() {
        String expectedOutput = "welcome";
        String actualOutput = welcomeController.welcome();
        Assertions.assertEquals(expectedOutput, actualOutput, "Expected output is not matching with actual output");
    }

    @Test
    public void testWelcomeFailure() {
        String unexpectedOutput = "hello";
        String actualOutput = welcomeController.welcome();
        Assertions.assertNotEquals(unexpectedOutput, actualOutput, "Unexpected output is matching with actual output");
    }
}
