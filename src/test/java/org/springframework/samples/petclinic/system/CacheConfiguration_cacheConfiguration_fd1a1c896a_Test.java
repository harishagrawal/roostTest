package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import javax.cache.configuration.MutableConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheConfiguration_cacheConfiguration_fd1a1c896a_Test {

    @InjectMocks
    private CacheConfiguration cacheConfiguration;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCacheConfiguration_StatisticsEnabled() {
        MutableConfiguration<Object, Object> config = new MutableConfiguration<>();
        config = (MutableConfiguration<Object, Object>) cacheConfiguration.cacheConfiguration();
        assertTrue(config.isStatisticsEnabled(), "Cache configuration statistics should be enabled");
    }

    @Test
    public void testCacheConfiguration_NotReadThrough() {
        MutableConfiguration<Object, Object> config = new MutableConfiguration<>();
        config = (MutableConfiguration<Object, Object>) cacheConfiguration.cacheConfiguration();
        assertTrue(!config.isReadThrough(), "Cache configuration read through should not be enabled");
    }
}
