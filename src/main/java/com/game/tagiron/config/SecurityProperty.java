package com.game.tagiron.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@Getter
@ConfigurationProperties(prefix = "server.security")
public class SecurityProperty {
    private final String[] allowOrigins;

    public SecurityProperty(String[] allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

}