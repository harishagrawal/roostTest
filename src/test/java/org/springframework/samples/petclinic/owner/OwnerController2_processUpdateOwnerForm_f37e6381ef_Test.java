package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OwnerController2_processUpdateOwnerForm_f37e6381ef_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
    }

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        verify(owners, times(1)).save(owner);
        assertThat(view).isEqualTo("redirect:/owners/{ownerId}");
    }

    @Test
    public void testProcessUpdateOwnerForm_Failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        verify(owners, times(0)).save(owner);
        assertThat(view).isEqualTo("owners/createOrUpdateOwnerForm");
    }
}
