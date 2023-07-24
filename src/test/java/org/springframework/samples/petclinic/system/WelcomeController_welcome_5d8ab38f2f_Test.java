package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class WelcomeController_welcome_5d8ab38f2f_Test {

    @Autowired
    private WelcomeController controller;

    @Test
    public void testWelcome() {
        String result = controller.welcome();
        assertEquals("welcome", result, "Expected and actual results do not match");
    }

    @Test
    public void testWelcomeFailure() {
        String result = controller.welcome();
        assertEquals("wrong", result, "Test failed because the expected output does not match the actual output");
    }
}
