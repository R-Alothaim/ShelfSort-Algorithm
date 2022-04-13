package com.shelfproject;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ShelfSortTest {

    @Test
    public void testBasicSort() {
        int[] input = {3, 4, 3, 11, 23, 4421, 2, 11, 2};
        int[] expected = {2, 2, 3, 3, 4, 11, 11, 23, 4421};
        ShelfSort.sort(input, 29999999);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        ShelfSort.sort(input, 29999999);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        ShelfSort.sort(input, 29999999);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testDuplicates() {
        int[] input = {5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5};
        ShelfSort.sort(input, 29999999);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMixedDigitLengths() {
        int[] input = {100, 10, 1, 1000, 50};
        int[] expected = {1, 10, 50, 100, 1000};
        ShelfSort.sort(input, 29999999);
        assertArrayEquals(expected, input);
    }
}
