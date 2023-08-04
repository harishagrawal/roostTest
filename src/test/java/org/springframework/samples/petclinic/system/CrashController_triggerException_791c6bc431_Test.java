package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CrashController_triggerException_791c6bc431_Test {

    @InjectMocks
    CrashController crashController = new CrashController();

    @Test
    public void testTriggerException_Success() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            crashController.triggerException();
        });

        String expectedMessage = "Expected: controller used to showcase what happens when an exception is thrown";
        String actualMessage = exception.getMessage();

        assert expectedMessage.equals(actualMessage);
    }

    @Test
    public void testTriggerException_Failure() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            crashController.triggerException();
        });

        String expectedMessage = "500 INTERNAL_SERVER_ERROR \"Expected: controller used to showcase what happens when an exception is thrown\"";
        String actualMessage = exception.getMessage();

        assert !expectedMessage.equals(actualMessage);
    }
}
