package com.poluhin.search.binary_search;

import com.poluhin.search.Search;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private final static Logger logger = Logger.getLogger(BinarySearchTest.class.getName());

    private Random random;
    private Integer[] integerArray;
    private Integer[] sameIntegerArray;
    private Integer[] nonSortIntegerArray;
    private String[] stringArray;
    private Search<Integer> biIntegerSearch;
    private int size;

    private void init() {
        random = new Random();
        size = random.nextInt(1000);
        integerArray = IntStream.range(0, size).boxed().toArray(Integer[]::new);
        final var sameInt = random.nextInt();
        sameIntegerArray = IntStream.range(0, size).mapToObj(i -> i = sameInt).toArray(Integer[]::new);
        biIntegerSearch = new BinarySearch<>();
        // TODO Add init for another arrays
    }

    @Test
    void search() {
        init();
        IntStream.range(0, size).forEach(i -> {
            try {
                assertEquals(i, biIntegerSearch.search(integerArray, i));
            } catch (AssertionFailedError e) {
                logger.warning("Test error, testing information: " +
                        String.format("size = %d, index (and element) = %d", size, i));
                throw e;
            }
        });
    }

    @Test
    void first() {
        init();
        assertEquals(0, biIntegerSearch.first(sameIntegerArray, sameIntegerArray[random.nextInt(size)]));
    }

    @Test
    void last() {
        init();
        assertEquals(size - 1, biIntegerSearch.last(sameIntegerArray, sameIntegerArray[random.nextInt(size)]));
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