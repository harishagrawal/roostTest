package org.springframework.samples.petclinic.owner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PetController_PetController_2c07014f29_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPetControllerConstructor() {
        assertThat(petController).isNotNull();
    }
}
