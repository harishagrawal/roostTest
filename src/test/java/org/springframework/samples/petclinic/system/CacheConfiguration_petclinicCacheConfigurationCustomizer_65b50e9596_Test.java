package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CacheConfiguration_petclinicCacheConfigurationCustomizer_65b50e9596_Test {

    private CacheConfiguration cacheConfiguration;

    @Mock
    private CacheManager cacheManager;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        cacheConfiguration = new CacheConfiguration();
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        MutableConfiguration<Object, Object> mutableConfiguration = new MutableConfiguration<>();

        when(cacheConfiguration.cacheConfiguration()).thenReturn(mutableConfiguration);
        customizer.customize(cacheManager);

        verify(cacheManager).createCache("vets", mutableConfiguration);
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizerFailure() {
        JCacheManagerCustomizer customizer = cacheConfiguration.petclinicCacheConfigurationCustomizer();
        MutableConfiguration<Object, Object> mutableConfiguration = new MutableConfiguration<>();

        when(cacheConfiguration.cacheConfiguration()).thenReturn(mutableConfiguration);
        customizer.customize(cacheManager);

        verify(cacheManager).createCache("wrongCache", mutableConfiguration);
    }
}
