package org.springframework.samples.petclinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

public class PetClinicRuntimeHints_registerHints_b9a071d40e_Test {

    @Mock
    private RuntimeHints hints;

    private PetClinicRuntimeHints_registerHints_b9a071d40e petClinicRuntimeHints;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petClinicRuntimeHints = new PetClinicRuntimeHints_registerHints_b9a071d40e();
    }

    @Test
    public void testRegisterHints() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        petClinicRuntimeHints.registerHints(hints, classLoader);

        verify(hints, times(1)).resources().registerPattern("db/*");
        verify(hints, times(1)).resources().registerPattern("messages/*");
        verify(hints, times(1)).resources().registerPattern("META-INF/resources/webjars/*");
        verify(hints, times(1)).resources().registerPattern("mysql-default-conf");
        verify(hints, times(1)).serialization().registerType(BaseEntity.class);
        verify(hints, times(1)).serialization().registerType(Person.class);
        verify(hints, times(1)).serialization().registerType(Vet.class);
    }
}
