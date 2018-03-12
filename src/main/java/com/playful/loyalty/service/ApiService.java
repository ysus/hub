package com.playful.loyalty.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playful.loyalty.domain.Product;

@Service
public class ApiService {

	RestTemplate restTemplate;

	static String buildUrl(String url) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(url).buildAndExpand().encode();
		return uriComponents.toUriString();
	}

	@Autowired
	MyResponseErrorHandler myResponseErrorHandler;

	public ApiService() {
		restTemplate = new RestTemplate();
	}

	@Async
	public CompletableFuture<List<Product>> getInfo(String url, Boolean isHateoas) {

		final CompletableFuture<List<Product>> promise = new CompletableFuture<>();

		if (isHateoas)
			restTemplate = restTemplate();

		restTemplate.setErrorHandler(myResponseErrorHandler);
		ResponseEntity<PagedResources<Product>> responseEntity = null;

		try {
			responseEntity = restTemplate.exchange(buildUrl(url), HttpMethod.GET, null,
					new ParameterizedTypeReference<PagedResources<Product>>() {
					});
			PagedResources<Product> resources = responseEntity.getBody();
			List<Product> promotions = new ArrayList<>(resources.getContent());
			promise.complete(promotions);

		} catch (HttpClientErrorException e) {
			promise.completeExceptionally(e);
		}

		catch (HttpServerErrorException e) {
			promise.completeExceptionally(e);
		}

		catch (RestClientException e) {
			promise.completeExceptionally(e);
		}

		return promise;

	}

	private RestTemplate restTemplate() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new Jackson2HalModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);
		return new RestTemplate(Arrays.asList(converter));
	}

}
