package com.poluhin.search.binary_search;

import com.poluhin.search.Search;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
            logger.info("Test search, testing info: " +
                    String.format("size = %d, index (and element) = %d", size, i));
            assertEquals(i, biIntegerSearch.search(integerArray, i));
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
        init();
        assertTrue(Arrays.equals(Stream.of(sameIntegerArray).mapToInt(Integer::intValue).toArray(),
                biIntegerSearch.all(sameIntegerArray, sameIntegerArray[0])));
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