package org.springframework.samples.petclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

import static org.mockito.Mockito.verify;

public class PetClinicRuntimeHints_registerHints_b9a071d40e_Test {

    @Mock
    private RuntimeHints runtimeHints;

    @InjectMocks
    private RuntimeHintsRegistrar runtimeHintsRegistrar;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterHints() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        runtimeHintsRegistrar.registerHints(runtimeHints, classLoader);

        verify(runtimeHints.resources()).registerPattern("db/*");
        verify(runtimeHints.resources()).registerPattern("messages/*");
        verify(runtimeHints.resources()).registerPattern("META-INF/resources/webjars/*");
        verify(runtimeHints.resources()).registerPattern("mysql-default-conf");
        verify(runtimeHints.serialization()).registerType(BaseEntity.class);
        verify(runtimeHints.serialization()).registerType(Person.class);
        verify(runtimeHints.serialization()).registerType(Vet.class);
    }

    @Test
    public void testRegisterHints_withNullClassLoader() {
        runtimeHintsRegistrar.registerHints(runtimeHints, null);

        verify(runtimeHints.resources()).registerPattern("db/*");
        verify(runtimeHints.resources()).registerPattern("messages/*");
        verify(runtimeHints.resources()).registerPattern("META-INF/resources/webjars/*");
        verify(runtimeHints.resources()).registerPattern("mysql-default-conf");
        verify(runtimeHints.serialization()).registerType(BaseEntity.class);
        verify(runtimeHints.serialization()).registerType(Person.class);
        verify(runtimeHints.serialization()).registerType(Vet.class);
    }
}
