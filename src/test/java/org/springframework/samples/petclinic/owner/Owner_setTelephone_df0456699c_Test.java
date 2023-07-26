package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner_setTelephone_df0456699c_Test {

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
    }

    @Test
    public void testSetTelephone_ValidInput() {
        String telephone = "1234567890";
        owner.setTelephone(telephone);
        assertEquals(telephone, owner.getTelephone(), "Telephone should be set correctly");
    }

    @Test
    public void testSetTelephone_NullInput() {
        String telephone = null;
        owner.setTelephone(telephone);
        assertEquals(telephone, owner.getTelephone(), "Telephone should be null");
    }
}
