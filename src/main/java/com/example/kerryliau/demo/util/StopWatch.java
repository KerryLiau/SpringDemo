package com.example.kerryliau.demo.util;

import java.math.BigDecimal;



public class StopWatch {
    public static BigDecimal countMilliSeconds(Runnable runnable) {
        long begin, end;
        begin = System.nanoTime();
        runnable.run();
        end = System.nanoTime();
        return BigDecimal.valueOf((end - begin) / 1000000D);
    }
}
