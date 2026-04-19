package com.backline.test.common;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonHelper {

    private static final Logger LOG = LoggerFactory.getLogger(JsonHelper.class);
    private static final JsonFactory FACTORY = new JsonFactory();

    public static JsonParser createParser(String json) throws Exception {
        LOG.info("Creating JSON parser");
        return FACTORY.createParser(json);
    }

    /**
     * Builds a range map of severity labels.
     * Uses RangeMap.putAll() - a method whose signature changed in Guava 32.
     */
    public static RangeMap<Integer, String> severityRanges() {
        TreeRangeMap<Integer, String> base = TreeRangeMap.create();
        base.put(Range.closed(0, 39), "low");
        base.put(Range.closed(40, 69), "medium");
        base.put(Range.closed(70, 89), "high");
        base.put(Range.closed(90, 100), "critical");

        TreeRangeMap<Integer, String> merged = TreeRangeMap.create();
        RangeMap<Integer, ? extends String> sourceMap = base;
        merged.putAll(sourceMap);
        return ImmutableRangeMap.copyOf(merged);
    }
}
