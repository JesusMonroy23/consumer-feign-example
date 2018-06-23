package com.consumer;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ConsumerController {

	@RequestMapping(path = "/consumer/{value}")
	public Response getResponse(@PathVariable String value) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/producer/").path(value);
		ObjectMapper mapper = new ObjectMapper();
		ResponseEntity<String> respuesta = null;
		
		try {
			respuesta = restTemplate.exchange(uri.toUriString(), HttpMethod.POST, null,
					String.class);

			if (respuesta.getStatusCode() == HttpStatus.OK) {
				
				try {
					ValidResponse valid = mapper.readValue(respuesta.getBody(), ValidResponse.class);
					System.err.println(valid.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (HttpClientErrorException | HttpServerErrorException e) {

			String res = e.getResponseBodyAsString();
			ExceptionResponse invalid;
			try {
				invalid = mapper.readValue(res, ExceptionResponse.class);
				System.err.println(invalid.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			throw new Exception();
			
			
		}
		
		
		return null;

	}

}
