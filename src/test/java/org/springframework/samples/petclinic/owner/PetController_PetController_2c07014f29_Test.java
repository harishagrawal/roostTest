package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PetController_PetController_2c07014f29_Test {

    @MockBean
    private OwnerRepository ownerRepository;

    private PetController petController;

    @BeforeEach
    public void setup() {
        petController = new PetController();
    }

    @Test
    public void testPetControllerConstructor() {
        assertNotNull(petController);
    }

    @Test
    public void testPetControllerConstructorWithMockedOwnerRepository() {
        OwnerRepository mockedOwnerRepository = Mockito.mock(OwnerRepository.class);
        when(mockedOwnerRepository.findById(Mockito.anyInt())).thenReturn(null);

        PetController petControllerWithMockedRepo = new PetController();
        assertNotNull(petControllerWithMockedRepo);
    }

}
