package com.playful.loyalty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.playful.loyalty.domain.Product;
import com.playful.loyalty.service.ApiService;
import com.playful.loyalty.service.MyResponseErrorHandler;

@RestController
public class MyRestService {
	
	String urlP = "http://localhost:5050/productos";
	String urlV = "http://localhost:5050/viajes";
	String promosJsonUrl = "http://loyalty-hub-beta-backend.test/promotions";

    @Autowired
    ApiService apiService;
    private static final Logger log = LoggerFactory.getLogger(MyResponseErrorHandler.class);

	@RequestMapping(value = "/promotions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> promotions()  {
		
		Map<String, Object> response = new HashMap<>();
		
		response.putAll(responseAsync("productos",urlP,true));
		response.putAll(responseAsync("viajes",urlV,true));
      
		 return response;
	}
	
	private Map<String,Object>responseAsync(String field,String url,Boolean isHateoas) {
			
		Map<String, Object> result = new HashMap<>();
		CompletableFuture<List<Product>> page1 = null;
		
		try {
			page1 = apiService.getInfo(url,isHateoas);
			result.put(field, page1.get());
		     
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put(field,e.getMessage());
		}
		
		return result;
	
	}
	

}
