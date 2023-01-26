package com.reactiveopenai.reactivechatapi.handler;

import com.reactiveopenai.reactivechatapi.model.QueryRequest;
import com.reactiveopenai.reactivechatapi.service.ReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ReactiveHandler {

    @Autowired
    private ReactiveService reactiveService;

    public Mono<ServerResponse> sendQuestion(ServerRequest request) {
        return request.bodyToMono(QueryRequest.class)
                .flatMap(botRequest ->
                    Mono.just(reactiveService.askQuestion(botRequest))
                ).flatMap(chatGptResponse -> ServerResponse.created(null)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(chatGptResponse))
                );
    }
}
