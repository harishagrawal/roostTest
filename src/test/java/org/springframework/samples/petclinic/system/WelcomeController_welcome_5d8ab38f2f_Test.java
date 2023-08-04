package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WelcomeController_welcome_5d8ab38f2f_Test {

    @Autowired
    private WelcomeController controller;

    @Test
    public void testWelcome_Success() {
        String result = controller.welcome();
        assertThat(result).isEqualTo("welcome");
    }

    @Test
    public void testWelcome_Failure() {
        String result = controller.welcome();
        assertThat(result).isNotEqualTo("not welcome");
    }
}
