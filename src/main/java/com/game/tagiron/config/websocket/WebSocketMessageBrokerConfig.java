package com.game.tagiron.config.websocket;

import com.game.tagiron.config.SecurityProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

    private static final String ENDPOINT = "/ws-stomp";
    private static final String SIMPLE_BROKER = "/topic";
    private static final String PUBLISH = "/app";
    private final SecurityProperty securityProperty;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트가 구독할 topic prefix
        registry.enableSimpleBroker(SIMPLE_BROKER);

        // 클라이언트가 서버로 메세지 보낼때 붙일 prefix
        registry.setApplicationDestinationPrefixes(PUBLISH);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(ENDPOINT) // 웹소켓에 연결할 endpoint 설정. 최초 연결시 "ws://localhost:8080/ws-stomp 로 연결"
                .setAllowedOriginPatterns(securityProperty.getAllowOrigins())
                .withSockJS()
        ;

    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(jwtChannelInterceptor);
    }
}
