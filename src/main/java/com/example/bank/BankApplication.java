package com.example.bank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) throws JsonProcessingException {
//		SpringApplication.run(BankApplication.class, args);

//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonString = "[{\"name\":\"John\"}, {\"name\":\"Jane\"}]";
//
//		String jsonString2 = "{\"name\":\"Neeraj\", \"name2\":\"Gi\"}";
//		JsonNode node2 = objectMapper.readTree(jsonString2);
//
//		System.out.println(node2.toString());

//		ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(jsonString);
//
//		for (JsonNode node : arrayNode) {
//			String name = node.get("name").asText();
//			System.out.println(name);
//		}


//		System.out.println(arrayNode.toString());




		ObjectMapper mapper = new ObjectMapper();

		// Create ObjectNode
		ObjectNode person = mapper.createObjectNode();
		person.put("name", "Alice");
		person.put("age", 25);
//		System.out.println(person.get("nam"));    	// Returns null if key missing
//		JsonNode node = person.path("nam");				// Returns empty
//		System.out.println(node.isEmpty());
//		System.out.println(person.isObject());
//		System.out.println(person.isArray());
//		person.iterator();


		// Create ArrayNode
		ArrayNode hobbies = mapper.createArrayNode();
		hobbies.add("Reading");
		hobbies.add("Traveling");

		// Attach array to object
		person.set("hobbies", hobbies);

		// Print final JSON
		System.out.println(person.toPrettyString());

		// Access fields
		String name = person.get("name").asText();
		int age = person.get("age").asInt();

		System.out.println(name + " is " + age + " years old.");



	}

}
