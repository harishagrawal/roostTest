package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Configuration;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CacheConfiguration_petclinicCacheConfigurationCustomizer_65b50e9596_Test {

    @Mock
    CacheManager cacheManager;

    @InjectMocks
    CacheConfiguration cacheConfiguration;

    @Test
    public void testPetclinicCacheConfigurationCustomizer_Success() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        customizer.customize(cacheManager);
        verify(cacheManager).createCache("vets", new MutableConfiguration<>());
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer_Failure() {
        when(cacheManager.createCache("vets", new MutableConfiguration<>())).thenThrow(RuntimeException.class);
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        try {
            customizer.customize(cacheManager);
        } catch (RuntimeException e) {
            // TODO: Handle expected exception here
        }
    }
}
