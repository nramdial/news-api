package com.firsthelp.newsapi.config;

import com.firsthelp.newsapi.util.SearchFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }

    public static class StringToEnumConverter implements Converter<String, SearchFilter> {
        @Override
        public SearchFilter convert(String source) {
            return SearchFilter.valueOf(source.toUpperCase());
        }
    }

}
