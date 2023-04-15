package com.fer.rss.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configure a global mapping to exclude the id field for all entity classes
        modelMapper
                .getConfiguration()
                .setSkipNullEnabled(true)
                .setPropertyCondition(Conditions.isNotNull())
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setAmbiguityIgnored(true);

        return modelMapper;
    }
}

