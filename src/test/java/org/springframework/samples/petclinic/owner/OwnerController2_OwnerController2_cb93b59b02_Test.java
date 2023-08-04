package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OwnerController2_OwnerController2_cb93b59b02_Test {

    private OwnerRepository clinicService;
    private OwnerController2 ownerController2;

    @BeforeEach
    public void setup() {
        clinicService = Mockito.mock(OwnerRepository.class);
        ownerController2 = new OwnerController2(clinicService);
    }

    @Test
    public void testOwnerController2_Success() {
        assertNotNull(ownerController2);
    }

    @Test
    public void testOwnerController2_Failure() {
        assertThrows(NullPointerException.class, () -> new OwnerController2(null));
    }
}
