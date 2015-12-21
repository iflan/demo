package org.usc.demo.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 *
 * @author Shunli
 */
public class BiMapTest {
    public static void main(String[] args) {
        // Maps.synchronizedBiMap(bimap)

        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");

        logfileMap.put(4, "d.log");
        logfileMap.put(4, "d.log");
        // logfileMap.forcePut(5, "d.log");
        System.out.println("logfileMap:" + logfileMap);

    }
}
