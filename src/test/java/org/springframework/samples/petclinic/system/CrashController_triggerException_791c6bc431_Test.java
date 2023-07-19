package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CrashController_triggerException_791c6bc431_Test {

    @MockBean
    private CrashController crashController;

    @Test
    public void testTriggerException() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            crashController.triggerException();
        });

        String expectedMessage = "Expected: controller used to showcase what "
                + "happens when an exception is thrown";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testTriggerExceptionWithDifferentMessage() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            crashController.triggerException();
        });

        String unexpectedMessage = "Unexpected message";
        String actualMessage = exception.getMessage();

        Assertions.assertFalse(actualMessage.contains(unexpectedMessage));
    }
}
