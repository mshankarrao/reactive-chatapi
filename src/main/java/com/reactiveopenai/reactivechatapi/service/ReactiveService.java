package com.reactiveopenai.reactivechatapi.service;

import com.reactiveopenai.reactivechatapi.model.QueryRequest;
import com.reactiveopenai.reactivechatapi.model.OpenAIRequest;
import com.reactiveopenai.reactivechatapi.model.OpenAIResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReactiveService {

    private static RestTemplate restTemplate = new RestTemplate();
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String API_KEY = "";
    public static final String MODEL = "text-davinci-003";
    public static final Integer MAX_TOKEN = 300;
    public static final Double TEMPERATURE = 0.0;
    public static final Double TOP_P = 1.0;
    public static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    public static final String URL = "https://api.openai.com/v1/completions";


    //    Build headers
    public HttpEntity<OpenAIRequest> buildHttpEntity(OpenAIRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MEDIA_TYPE));
        headers.add(AUTHORIZATION, BEARER + API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    //    Generate response
    public OpenAIResponse getResponse(HttpEntity<OpenAIRequest> chatRequestHttpEntity) {
        ResponseEntity<OpenAIResponse> responseEntity = restTemplate.postForEntity(
                URL,
                chatRequestHttpEntity,
                OpenAIResponse.class);

        return responseEntity.getBody();
    }

    public OpenAIResponse askQuestion(QueryRequest botRequest) {
        return this.getResponse(
                this.buildHttpEntity(
                        new OpenAIRequest(
                                MODEL,
                                botRequest.getMessage(),
                                TEMPERATURE,
                                MAX_TOKEN,
                                TOP_P)));
    }
}





