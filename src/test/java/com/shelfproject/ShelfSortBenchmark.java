package com.shelfproject;

import com.shelfproject.util.ArrayUtils;
import java.util.Arrays;

public class ShelfSortBenchmark {

    @org.junit.Test
    public void benchmarkSmallArray() {
        int[] arr = ArrayUtils.generateRandom(100, 10000);
        long start = System.nanoTime();
        ShelfSort.sort(arr, 29999999);
        long elapsed = System.nanoTime() - start;
        System.out.printf("100 elements: %.3f ms%n", elapsed / 1_000_000.0);
        verifySorted(arr);
    }

    @org.junit.Test
    public void benchmarkMediumArray() {
        int[] arr = ArrayUtils.generateRandom(10_000, 100_000);
        long start = System.nanoTime();
        ShelfSort.sort(arr, 29999999);
        long elapsed = System.nanoTime() - start;
        System.out.printf("10,000 elements: %.3f ms%n", elapsed / 1_000_000.0);
        verifySorted(arr);
    }

    private void verifySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            assert arr[i] >= arr[i - 1] : "Array not sorted at index " + i;
        }
    }
}
