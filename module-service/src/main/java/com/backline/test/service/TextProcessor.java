package com.backline.test.service;

import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookupFactory;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor {

    public static String processTemplate(String template, Map<String, String> values) {
        StringSubstitutor substitutor = new StringSubstitutor(values);
        return substitutor.replace(template);
    }

    public static void main(String[] args) {
        Map<String, String> values = new HashMap<>();
        values.put("user", "admin");
        values.put("action", "deploy");

        String template = "User ${user} performed ${action}";
        System.out.println(processTemplate(template, values));
    }
}
