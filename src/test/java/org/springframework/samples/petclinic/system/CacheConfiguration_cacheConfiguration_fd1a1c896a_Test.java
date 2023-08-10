package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;

import javax.cache.configuration.MutableConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheConfiguration_cacheConfiguration_fd1a1c896a_Test {

    @InjectMocks
    private CacheConfiguration cacheConfiguration;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        cacheConfiguration = new CacheConfiguration();
    }

    @Test
    public void testCacheConfiguration() {
        javax.cache.configuration.Configuration<Object, Object> result = cacheConfiguration.cacheConfiguration();
        assertNotNull(result, "Cache configuration should not be null");
        assertTrue(result.isStatisticsEnabled(), "Cache configuration statistics should be enabled");
    }

    @Test
    public void testCacheConfigurationFailure() {
        try {
            javax.cache.configuration.Configuration<Object, Object> result = cacheConfiguration.cacheConfiguration();
            result.setStatisticsEnabled(false);
            assertTrue(result.isStatisticsEnabled(), "Cache configuration statistics should be enabled");
        } catch (UnsupportedOperationException e) {
            assertNotNull(e, "Exception should be thrown when trying to disable statistics");
        }
    }
}
