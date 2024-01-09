package com.enigma.anriticket.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(toBuilder = true)
public class CommondResponse <T>{
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
}
