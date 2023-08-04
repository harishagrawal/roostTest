package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner();
    }

    @Test
    public void testSetTelephone_success() {
        String telephone = "1234567890";
        owner.setTelephone(telephone);
        assertEquals(telephone, owner.getTelephone(), "Telephone number should match the set value");
    }

    @Test
    public void testSetTelephone_nullValue() {
        String telephone = null;
        owner.setTelephone(telephone);
        assertEquals(telephone, owner.getTelephone(), "Telephone number should match the set value even if it's null");
    }
}
