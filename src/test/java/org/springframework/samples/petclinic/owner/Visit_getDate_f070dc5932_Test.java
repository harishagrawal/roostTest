package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.BaseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDate_f070dc5932_Test {

    private BaseEntity baseEntityMock;

    @BeforeEach
    public void setup() {
        baseEntityMock = Mockito.mock(BaseEntity.class);
    }

    @Test
    public void testGetDateWithValidDate() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        Mockito.when(baseEntityMock.getDate()).thenReturn(testDate);

        LocalDate resultDate = baseEntityMock.getDate();
        assertEquals(testDate, resultDate, "Returned date should match the test date");
    }

    @Test
    public void testGetDateWithNullDate() {
        Mockito.when(baseEntityMock.getDate()).thenReturn(null);

        LocalDate resultDate = baseEntityMock.getDate();
        assertEquals(null, resultDate, "Returned date should be null as the date was not set");
    }
}
