package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.system.WelcomeController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class WelcomeController_welcome_5d8ab38f2f_Test {

    @Autowired
    private WelcomeController welcomeController;

    @Test
    public void testWelcome() {
        String result = welcomeController.welcome();
        assertEquals("welcome", result, "Expected output is 'welcome'");
    }

    @Test
    public void testWelcomeFailure() {
        String result = welcomeController.welcome();
        assertNotEquals("notwelcome", result, "Expected output is not 'notwelcome'");
    }
}
