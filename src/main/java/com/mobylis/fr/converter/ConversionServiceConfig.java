package com.mobylis.fr.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;

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
        formattingConversionService.addConverter(new MapToProductViewConverter());
        formattingConversionService.addConverter(new ProductViewToProductMysqlConverter());
        formattingConversionService.addConverter(new ProductMysqlToProductViewConverter());
        formattingConversionService.addConverter(new MapToProductEsConverter());
        formattingConversionService.addConverter(new ProductViewToProductEsConverter());
        formattingConversionService.addConverter(new ProductMysqlToProductEsConverter());
        formattingConversionService.addConverter(new MapToProductSearchDTOConverter());
        formattingConversionService.addConverter(new SearchHitsToProductSearchDTOListConverter());
        return formattingConversionService;
    }

}