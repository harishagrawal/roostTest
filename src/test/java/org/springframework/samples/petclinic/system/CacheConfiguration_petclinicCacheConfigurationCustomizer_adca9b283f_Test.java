package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;

import javax.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CacheConfiguration_petclinicCacheConfigurationCustomizer_adca9b283f_Test {

    @InjectMocks
    CacheConfiguration cacheConfiguration;

    @Mock
    CacheManager cacheManager;

    @BeforeEach
    public void setup() {
        // TODO: Initialize the mocks here if needed
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        customizer.customize(cacheManager);

        verify(cacheManager, times(1)).createCache("vets", cacheConfiguration.cacheConfiguration());
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer_NullCacheManager() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        
        try {
            customizer.customize(null);
        } catch (NullPointerException e) {
            assertEquals("CacheManager must not be null", e.getMessage());
        }
    }
}
