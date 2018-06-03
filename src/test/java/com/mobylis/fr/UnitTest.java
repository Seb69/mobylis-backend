package com.mobylis.fr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ANDRE
 * @since 21/02/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitTest {


    class MyKey {
        String id;
        String name;
    }

    @Test
    public void name() throws Exception {

        Map<String, String> map = new HashMap<>();

        map.put("A", "a");
        System.out.println("A".hashCode());
        map.put("B", "b");
        map.put("C", "c");
        map.put("D", "d");
        map.put("E", "e");
        map.put("F", "f");
        map.put("G", "g");
        map.put("H", "h");
        map.put("I", "h");
        map.put("J", "h");
        map.put("K", "h");
        map.put("L", "h");
        map.put("M", "h");
        map.put("N", "h");
        map.put("O", "h");
        map.put("P", "h");
        map.put("Q", "h");
        map.put("R", "h");
        map.put("S", "h");
        map.put("T", "h");
        map.put("U", "h");
        map.put("V", "h");
        map.put("W", "h");
        map.put("X", "h");
        map.put("Y", "h");
        map.put("Z", "h");

        System.out.println(map.toString());

    }
}
