package com.shelfproject.util;

import java.util.Random;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[] generateRandom(int size, int maxValue) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxValue) + 1;
        }
        return arr;
    }
}
