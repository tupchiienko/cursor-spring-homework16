package com.cursor.cursorspringhomework16.configuration;

import com.cursor.cursorspringhomework16.components.Head;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

    @Bean
    public Head head() {
        return new Head();
    }
}
