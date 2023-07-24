package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CrashController_triggerException_791c6bc431_Test {

    @Autowired
    CrashController crashController;

    @Test
    public void testTriggerException() {
        assertThrows(RuntimeException.class, () -> {
            crashController.triggerException();
        });
    }

    @Test
    public void testTriggerExceptionMessage() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            crashController.triggerException();
        });

        String expectedMessage = "Expected: controller used to showcase what happens when an exception is thrown";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
