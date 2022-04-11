package com.shelfproject;

import com.shelfproject.util.ArrayUtils;

public class ShelfSortDemo {

    public static void main(String[] args) {
        System.out.println("=== Shelf Sort Algorithm Demo ===\n");

        int[] small = {3, 4, 3, 11, 23, 4421, 2, 11, 2};
        System.out.println("Input:  " + ArrayUtils.toString(small));
        ShelfSort.sort(small, 29999999);
        System.out.println("Sorted: " + ArrayUtils.toString(small));

        System.out.println();

        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println("Input:  " + ArrayUtils.toString(sorted));
        ShelfSort.sort(sorted, 29999999);
        System.out.println("Sorted: " + ArrayUtils.toString(sorted));

        System.out.println();

        int[] reversed = {50, 40, 30, 20, 10};
        System.out.println("Input:  " + ArrayUtils.toString(reversed));
        ShelfSort.sort(reversed, 29999999);
        System.out.println("Sorted: " + ArrayUtils.toString(reversed));
    }
}
