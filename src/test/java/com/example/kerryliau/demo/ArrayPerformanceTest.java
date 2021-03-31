package com.example.kerryliau.demo;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.kerryliau.demo.util.StopWatch;

public class ArrayPerformanceTest {
    public static void main(String[] args) {
        var count = 10000;
        for (var i = 0; i < count; i++) {
            var arr = returnArray(256);
            receiveArray(arr);
        }

        var arrayDuration = StopWatch.countMilliSeconds(() -> {
            for (var i = 0; i < count; i++) {
                var arr = returnArray(256);
                receiveArray(arr);
            }
        });
        System.out.println(arrayDuration);

        var mapDuration = StopWatch.countMilliSeconds(() -> {
            for (var i = 0; i < count; i++) {
                var arr = returnMap(256);
                receiveMap(arr);
            }
        });
        System.out.println(mapDuration);
        System.out.println("rate: " + mapDuration.divide(arrayDuration, 3, RoundingMode.HALF_DOWN));
    }

    static int[][] returnArray(int num) {
        var array = new int[num][2];
        for (var i = 0; i < array.length; i++) {
            array[i][0] = i;
            array[i][1] = i;
        }
        return array;
    }

    static Map<Integer, List<Integer>> returnMap(int num) {
        var map = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < num; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(i);
            map.get(i).add(i);
        }
        return map;
    }

    static int receiveArray(int[][] array) {
        var a = 0;
        for (var arr : array) {
            for (var i : arr) {
                a += i;
            }
        }
        return a;
    }

    static int receiveMap(Map<Integer, List<Integer>> map) {
        var a = 0;
        for (var e : map.entrySet()) {
            for (var i : e.getValue()) {
                a += i;
            }
        }
        return a;
    }
}
