package com.backline.test.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.backline.test.common.JsonHelper;

import java.util.Map;

public class ApiApp {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static JsonNode parseRequest(String json) throws Exception {
        return MAPPER.readTree(json);
    }

    public static String toJson(Map<String, Object> data) throws Exception {
        return MAPPER.writeValueAsString(data);
    }

    public static void main(String[] args) throws Exception {
        String sample = "{\"name\": \"test\", \"value\": 42}";
        JsonNode node = parseRequest(sample);
        System.out.println("Parsed: " + node.get("name").asText());
    }
}
