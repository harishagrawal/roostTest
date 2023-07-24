package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import javax.cache.configuration.MutableConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheConfiguration_cacheConfiguration_fd1a1c896a_Test {

    @InjectMocks
    private CacheConfiguration cacheConfiguration;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCacheConfiguration_StatisticsEnabled() {
        MutableConfiguration<Object, Object> config = (MutableConfiguration<Object, Object>) cacheConfiguration.cacheConfiguration();
        assertEquals(true, config.isStatisticsEnabled());
    }

    @Test
    public void testCacheConfiguration_NotReadThrough() {
        MutableConfiguration<Object, Object> config = (MutableConfiguration<Object, Object>) cacheConfiguration.cacheConfiguration();
        assertEquals(false, config.isReadThrough());
    }
}
