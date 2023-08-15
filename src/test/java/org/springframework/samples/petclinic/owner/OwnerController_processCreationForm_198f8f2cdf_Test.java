package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerController_processCreationForm_198f8f2cdf_Test {

    @Mock
    private BindingResult result;

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1);
    }

    @Test
    void testProcessCreationForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any(Owner.class))).thenReturn(owner);

        String view = ownerController.processCreationForm(owner, result);

        verify(owners, times(1)).save(any(Owner.class));
        assertThat(view).isEqualTo("redirect:/owners/1");
    }

    @Test
    void testProcessCreationForm_HasErrors() {
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processCreationForm(owner, result);

        verify(owners, times(0)).save(any(Owner.class));
        assertThat(view).isEqualTo("owners/createOrUpdateOwnerForm");
    }
}
