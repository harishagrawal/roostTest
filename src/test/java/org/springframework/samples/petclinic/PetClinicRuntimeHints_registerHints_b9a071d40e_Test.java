package org.springframework.samples.petclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PetClinicRuntimeHints_registerHints_b9a071d40e_Test {

    @Mock
    private RuntimeHints runtimeHints;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterHints() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        PetClinicRuntimeHints_registerHints_b9a071d40e petClinicRuntimeHints = new PetClinicRuntimeHints_registerHints_b9a071d40e();
        petClinicRuntimeHints.registerHints(runtimeHints, classLoader);

        verify(runtimeHints, times(1)).resources().registerPattern("db/*");
        verify(runtimeHints, times(1)).resources().registerPattern("messages/*");
        verify(runtimeHints, times(1)).resources().registerPattern("META-INF/resources/webjars/*");
        verify(runtimeHints, times(1)).resources().registerPattern("mysql-default-conf");
        verify(runtimeHints, times(1)).serialization().registerType(BaseEntity.class);
        verify(runtimeHints, times(1)).serialization().registerType(Person.class);
        verify(runtimeHints, times(1)).serialization().registerType(Vet.class);
    }
}
