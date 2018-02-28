package com.mobylis.fr.converter;

import com.mobylis.fr.converter.ProductMapToProductSearchDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Configuration
public class ConversionServiceConfig {

    @Bean
    @Primary
    ConversionService conversionService() {
        final FormattingConversionService formattingConversionService = new FormattingConversionService();
        formattingConversionService.addConverter(new ProductMapToProductSearchDTO());
        return formattingConversionService;
    }

}