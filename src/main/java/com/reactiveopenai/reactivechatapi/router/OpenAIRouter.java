package com.reactiveopenai.reactivechatapi.router;


import com.reactiveopenai.reactivechatapi.handler.ReactiveHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class OpenAIRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ReactiveHandler reactiveHandler) {

        return RouterFunctions
                .route(POST("/api/chat").and(accept(MediaType.APPLICATION_JSON)), reactiveHandler::sendQuestion);
    }
}