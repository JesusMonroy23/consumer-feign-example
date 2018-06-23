package com.consumer;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseConverter {
	
	public static <T extends Object> T converter(String json, Class<T> type) {
		ObjectMapper mapper = new ObjectMapper();
		Object respuesta = null;
		try {
			respuesta = mapper.readValue(json, type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return type.cast(respuesta);
	}

}
