package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class Owner_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetTelephone_success() {
        String expectedTelephone = "1234567890";
        owner.setTelephone(expectedTelephone);
        assertEquals(expectedTelephone, owner.getTelephone());
    }

    @Test
    public void testSetTelephone_emptyString() {
        String expectedTelephone = "";
        owner.setTelephone(expectedTelephone);
        assertEquals(expectedTelephone, owner.getTelephone());
    }

    @Test
    public void testSetTelephone_null() {
        String expectedTelephone = null;
        owner.setTelephone(expectedTelephone);
        assertEquals(expectedTelephone, owner.getTelephone());
    }
}
