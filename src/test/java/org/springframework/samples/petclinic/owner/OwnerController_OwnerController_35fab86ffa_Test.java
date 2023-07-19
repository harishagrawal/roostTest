package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerController ownerController;

    @MockBean
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setup() {
        ownerController = new OwnerController();
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(new Owner());
        ownerController.setOwnerRepository(ownerRepository);
    }

    @Test
    public void testOwnerControllerConstructor_success() {
        OwnerRepository testOwnerRepository = Mockito.mock(OwnerRepository.class);
        OwnerController testOwnerController = new OwnerController();
        testOwnerController.setOwnerRepository(testOwnerRepository);
        assertThat(testOwnerController).isNotNull();
    }

    @Test
    public void testOwnerControllerConstructor_failure() {
        OwnerController testOwnerController = null;
        try {
            testOwnerController = new OwnerController();
            testOwnerController.setOwnerRepository(null);
        } catch (IllegalArgumentException e) {
            assertThat(e).hasMessage("OwnerRepository must not be null");
            assertThat(testOwnerController).isNull();
        }
    }
}
