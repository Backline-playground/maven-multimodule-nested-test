package com.backline.test.common;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonHelper {

    private static final Logger LOG = LoggerFactory.getLogger(JsonHelper.class);
    private static final JsonFactory FACTORY = new JsonFactory();

    public static JsonParser createParser(String json) throws Exception {
        LOG.info("Creating JSON parser");
        return FACTORY.createParser(json);
    }
}
