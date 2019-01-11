package com.poluhin.search.binary_search;

import com.poluhin.search.Search;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private Random random;
    private Integer[] integerArray;
    private Integer[] nonSortIntegerArray;
    private String[] stringArray;
    private Search<Integer> biIntegerSearch;
    private int size;

    private void init() {
        random = new Random();
        size = random.nextInt(1000);
        integerArray = IntStream.range(0, size).boxed().toArray(Integer[]::new);
        biIntegerSearch = new BinarySearch<>();
        // TODO Add init for another arrays
    }

    @Test
    void search() {
        init();
        IntStream.range(0, size).forEach(i -> assertEquals(i, biIntegerSearch.search(integerArray, i)));
    }

    @Test
    void first() {
    }

    @Test
    void last() {
    }

    @Test
    void all() {
    }

    @Test
    void allStream() {
    }

    @Test
    void sortAndSearch() {
    }

    @Test
    void sortAndFirst() {
    }

    @Test
    void sortAndLast() {
    }

    @Test
    void sortAndAll() {
    }

    @Test
    void sortAndAllStream() {
    }
}