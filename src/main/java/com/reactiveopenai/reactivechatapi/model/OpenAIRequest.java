package com.reactiveopenai.reactivechatapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OpenAIRequest implements Serializable {

    public OpenAIRequest(String model, String prompt, Double temperature, Integer maxTokens, Double topP) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = maxTokens;
        this.top_p = topP;
    }

    private String model;
    private String prompt;
    private Double temperature;
    @JsonProperty("max_tokens")
    private Integer max_tokens;
    @JsonProperty("top_p")
    private Double top_p;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Double getTop_p() {
        return top_p;
    }

    public void setTop_p(Double top_p) {
        this.top_p = top_p;
    }
}