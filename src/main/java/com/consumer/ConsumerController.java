package com.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProducerFeign producer;

	@RequestMapping(path = "/consumer/{value}")
	public Response getResponse(@PathVariable String value) throws Exception {
		
		
		ResponseEntity<ValidResponse> respuesta = producer.getValidResponse("application/json", "uuid", value);
		System.err.println(respuesta.getBody());

//		UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/producer/").path(value);
//
//		
//		try {
//			ResponseEntity<String> respuesta = restTemplate.exchange(uri.toUriString(), HttpMethod.POST, null,
//					String.class);
//
//			if (respuesta.getStatusCode() == HttpStatus.OK) {
//				ValidResponse valid = ResponseConverter.converter(respuesta.getBody(), ValidResponse.class);
//				System.err.println(valid.toString());
//			}
//
//		} catch (HttpClientErrorException | HttpServerErrorException e) {
//			ExceptionResponse invalid = ResponseConverter.converter(e.getResponseBodyAsString(), ExceptionResponse.class);
//			System.err.println(invalid.toString());
//			
//			throw new Exception();
//		}

		return null;

	}

	

}
