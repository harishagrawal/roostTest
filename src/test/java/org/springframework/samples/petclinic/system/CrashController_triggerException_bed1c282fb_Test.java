package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CrashController_triggerException_bed1c282fb_Test {

    private CrashController crashController = new CrashController();

    @Test
    public void testTriggerException_RuntimeException() {
        assertThrows(RuntimeException.class, () -> crashController.triggerException());
    }

    @Test
    public void testTriggerException_ErrorMessage() {
        Exception exception = assertThrows(RuntimeException.class, () -> crashController.triggerException());
        String expectedMessage = "Expected: controller used to showcase what happens when an exception is thrown";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
