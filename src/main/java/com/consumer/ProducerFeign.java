package com.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "producer", url = "http://localhost:9090")
public interface ProducerFeign {
	@RequestMapping(path = "/producer/{value}", method = RequestMethod.POST)
	public ResponseEntity<ValidResponse> getValidResponse(
			@RequestHeader(name = "Accept", required = true) String Accept,
			@RequestHeader(name = "uuid", required = true) String uuid,
			@PathVariable(name = "value") String value);

}
