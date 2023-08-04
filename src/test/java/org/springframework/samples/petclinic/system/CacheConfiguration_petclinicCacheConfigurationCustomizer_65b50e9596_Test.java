package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class CacheConfiguration_petclinicCacheConfigurationCustomizer_65b50e9596_Test {

    @InjectMocks
    CacheConfiguration cacheConfiguration;

    @Mock
    CacheManager cacheManager;

    @Mock
    MutableConfiguration<Object, Object> mutableConfiguration;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        cacheConfiguration = new CacheConfiguration();
        cacheManager = Mockito.mock(CacheManager.class);
        mutableConfiguration = Mockito.mock(MutableConfiguration.class);
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        customizer.customize(cacheManager);

        verify(cacheManager, times(1)).createCache("vets", mutableConfiguration);
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer_NullCacheManager() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        customizer.customize(null);

        verify(cacheManager, times(0)).createCache("vets", mutableConfiguration);
    }
}
