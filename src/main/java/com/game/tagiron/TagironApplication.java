package com.game.tagiron;

import com.game.tagiron.config.SecurityProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SecurityProperty.class)
public class TagironApplication {

    public static void main(String[] args) {
        SpringApplication.run(TagironApplication.class, args);
    }

}
