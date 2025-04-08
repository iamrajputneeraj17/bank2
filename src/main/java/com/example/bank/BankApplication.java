package com.example.bank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) throws JsonProcessingException {
//		SpringApplication.run(BankApplication.class, args);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "[{\"name\":\"John\"}, {\"name\":\"Jane\"}]";

		String jsonString2 = "{\"name\":\"Neeraj\", \"name2\":\"Gi\"}";
		JsonNode node2 = objectMapper.readTree(jsonString2);

		System.out.println(node2.toString());

		ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(jsonString);
//
//		for (JsonNode node : arrayNode) {
//			String name = node.get("name").asText();
//			System.out.println(name);
//		}


		System.out.println(arrayNode.toString());


	}

}
