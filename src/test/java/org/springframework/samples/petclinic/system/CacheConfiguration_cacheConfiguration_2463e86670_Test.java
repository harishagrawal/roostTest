package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import javax.cache.configuration.MutableConfiguration;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CacheConfiguration_cacheConfiguration_2463e86670_Test {

    @MockBean
    private CacheConfiguration cacheConfiguration;

    private MutableConfiguration<Object, Object> mutableConfiguration;

    @BeforeEach
    public void setUp() {
        mutableConfiguration = new MutableConfiguration<>();
        when(cacheConfiguration.cacheConfiguration()).thenReturn(mutableConfiguration);
    }

    @Test
    public void testCacheConfiguration_statisticsEnabled() {
        mutableConfiguration.setStatisticsEnabled(true);
        assertTrue(mutableConfiguration.isStatisticsEnabled());
    }

    @Test
    public void testCacheConfiguration_statisticsDisabled() {
        mutableConfiguration.setStatisticsEnabled(false);
        assertFalse(mutableConfiguration.isStatisticsEnabled());
    }
}
