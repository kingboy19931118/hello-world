package com.arbor.note.basic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * com.arbor.note.basic.LamdaParallelDemo
 *
 * @author Joem
 * @date 2020-07-01
 * @since v2.0.0
 */
public class LamdaParallelDemo {

    public static void main(String[] args) {
        System.out.println(measureSumPerf(LamdaParallelDemo::sideEffectParallelSum, 10_000_000L));
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total.get();
    }

    public static class Accumulator {
        public AtomicLong total = new AtomicLong(0);
        public void add(long value) { total.getAndAdd(value); }
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
