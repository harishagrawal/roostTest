package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Owner_getCity_e8cb16672d_Test {

    @InjectMocks
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCityWhenCityIsNull() {
        owner.setCity(null);
        assertNull(owner.getCity());
    }

    @Test
    public void testGetCityWhenCityIsNotNull() {
        String testCity = "Test City";
        owner.setCity(testCity);
        assertEquals(testCity, owner.getCity());
    }
}
