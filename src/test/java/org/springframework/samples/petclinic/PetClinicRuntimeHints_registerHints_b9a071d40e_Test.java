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

class PetClinicRuntimeHintsRegisterHintsTest {

    @Mock
    private RuntimeHints hints;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterHints() {
        PetClinicRuntimeHintsRegisterHints registerHints = new PetClinicRuntimeHintsRegisterHints();
        registerHints.registerHints(hints, getClass().getClassLoader());

        verify(hints.resources(), times(1)).registerPattern("db/*");
        verify(hints.resources(), times(1)).registerPattern("messages/*");
        verify(hints.resources(), times(1)).registerPattern("META-INF/resources/webjars/*");
        verify(hints.resources(), times(1)).registerPattern("mysql-default-conf");
        verify(hints.serialization(), times(1)).registerType(BaseEntity.class);
        verify(hints.serialization(), times(1)).registerType(Person.class);
        verify(hints.serialization(), times(1)).registerType(Vet.class);
    }

    @Test
    public void testRegisterHintsWithNullClassLoader() {
        PetClinicRuntimeHintsRegisterHints registerHints = new PetClinicRuntimeHintsRegisterHints();
        registerHints.registerHints(hints, null);

        verify(hints.resources(), times(1)).registerPattern("db/*");
        verify(hints.resources(), times(1)).registerPattern("messages/*");
        verify(hints.resources(), times(1)).registerPattern("META-INF/resources/webjars/*");
        verify(hints.resources(), times(1)).registerPattern("mysql-default-conf");
        verify(hints.serialization(), times(1)).registerType(BaseEntity.class);
        verify(hints.serialization(), times(1)).registerType(Person.class);
        verify(hints.serialization(), times(1)).registerType(Vet.class);
    }
}
