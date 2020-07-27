package com.roshik.tasks.task4_4;

import java.util.*;

public class Main4_4 {

    public static <K, V> Map<V, Collection<K>> swap(Map<K,V> map) {

        Map<V, Collection<K>> resultMap = new HashMap<>();

        for (var i : map.entrySet()) {
            Collection<K> valuelist = resultMap.get(i.getValue());
            if (valuelist == null) {
                valuelist = new ArrayList<K>();
                resultMap.put(i.getValue(), valuelist);
            }
            valuelist.add(i.getKey());
        }
        return resultMap;


    }

    public static void main(String[] args) {

        var t = new HashMap<String, Integer>();
        t.put("Anna", 100);
        t.put("Masha", 200);
        t.put("Andjey", 100);

        var d = swap(t);
    }
}
