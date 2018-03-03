package com.mobylis.fr.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
public class Map_Mock {

    public static Map<String, Object> create() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "jbhds");
        map.put("description", "jbhds");
        map.put("price", "100");
        map.put("brand", "jbhds");
        map.put("category", "jbhds");
        map.put("images", List.of("imageA", "imageB"));
        return map;
    }


    public static Map<String, Object> createWithoutImages() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "jbhds");
        map.put("description", "jbhds");
        map.put("price", "jbhds");
        map.put("brand", "jbhds");
        map.put("category", "jbhds");
        return map;
    }

}
