package com.mobylis.fr.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Load configuration file for local development use only
 * For TEST and PROD, environment properties are manger with docker
 * @author ANDRE
 * @since 09/12/2017
 */
@Configuration
@PropertySource("file:${MOBYLIS_CONFIG_FILE}")
@Profile({"dev", "development"})
public class EnvironmentPropertiesConfiguration {
}
