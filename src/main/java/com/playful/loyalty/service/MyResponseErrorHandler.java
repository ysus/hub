package com.playful.loyalty.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

@Component
public class MyResponseErrorHandler implements ResponseErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(MyResponseErrorHandler.class);

    private List<HttpStatus> acceptableStatus;

    public  MyResponseErrorHandler(@Value("${good-status}") String goodStatus) {

        acceptableStatus = Arrays.stream(goodStatus.split(","))
                .map(HttpStatus::valueOf)
                .collect(Collectors.toList()) ;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
        HttpStatus statusCode = response.getStatusCode();
        switch (statusCode.series()) {
            case CLIENT_ERROR:
                throw new HttpClientErrorException(statusCode,response.getStatusText());
            case SERVER_ERROR:
                throw new HttpServerErrorException(statusCode, response.getStatusText());
            default:
                throw new RestClientException("Unknown status code [" + statusCode + "]");
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !acceptableStatus.contains(response.getStatusCode());

    }
}

