package com.api.springsample.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static LocalDateTimeSerializer LOCAL_DATE_TIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT));

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, LOCAL_DATE_TIME_SERIALIZER);
        return new ObjectMapper().registerModule(javaTimeModule);
    }
}
