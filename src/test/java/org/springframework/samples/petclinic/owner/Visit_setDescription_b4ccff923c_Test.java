package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.model.BaseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Visit_setDescription_b4ccff923c_Test {

    private Visit visit;

    @MockBean
    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        visit = new Visit();
        when(baseEntity.getDescription()).thenReturn("Test Description");
    }

    @Test
    public void testSetDescription_Success() {
        visit.setDescription("Test Description");
        assertEquals("Test Description", visit.getDescription());
    }

    @Test
    public void testSetDescription_Null() {
        visit.setDescription(null);
        assertEquals(null, visit.getDescription());
    }
}
