package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import javax.cache.configuration.MutableConfiguration;

@SpringBootTest
public class CacheConfiguration_cacheConfiguration_fd1a1c896a_Test {

    @Test
    public void testCacheConfiguration() {
        MutableConfiguration<Object, Object> config = new MutableConfiguration<>();
        config.setStatisticsEnabled(true);
        assertEquals(config, cacheConfiguration());
    }

    @Test
    public void testCacheConfigurationStatistics() {
        MutableConfiguration<Object, Object> config = cacheConfiguration();
        assertTrue(config.isStatisticsEnabled());
    }

    private MutableConfiguration<Object, Object> cacheConfiguration() {
        MutableConfiguration<Object, Object> config = new MutableConfiguration<>();
        config.setStatisticsEnabled(true);
        return config;
    } 
}
