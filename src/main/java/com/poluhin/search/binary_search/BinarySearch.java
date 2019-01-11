package com.poluhin.search.binary_search;

import com.poluhin.search.Search;

import java.util.logging.Logger;
import java.util.stream.Stream;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    private static Logger logger = Logger.getLogger(BinarySearch.class.getName());
    private static final int NOT_FOUND = -1;

    @Override
    public int search(E[] a, E e) {
        return recursionSearch(a, e, 0, a.length - 1);
    }

    private int recursionSearch(E[] a, E e, int start, int end) {
        final int simplePos = simplePositions(a, e, start, end);
        if (simplePos != NOT_FOUND) return simplePos;

        final int middle = (end + start) >>> 1;
        final int cmp = a[middle].compareTo(e);

        if (cmp < 0) return recursionSearch(a, e, start + 1, middle);
        if (cmp > 0) return recursionSearch(a, e, middle, end - 1);
        return middle;
    }

    private int simplePositions(E[] a, E e, int start, int end) {
        if (start > end || start < 0 || end > a.length - 1 || a.length == 0) return NOT_FOUND;
        if (a.length == 1) return 0;
        if (a[0].equals(e)) return 0;
        if (a[a.length - 1].equals(e)) return a.length - 1;
        return NOT_FOUND;
    }

    @Override
    public int first(E[] a, E e) {
        return 0;
    }

    @Override
    public int last(E[] a, E e) {
        return 0;
    }

    @Override
    public int[] all(E[] a, E e) {
        return new int[0];
    }

    @Override
    public Stream<E> allStream(E[] a, E e) {
        return null;
    }

    @Override
    public int sortAndSearch(E[] a, E e) {
        return 0;
    }

    @Override
    public int sortAndFirst(E[] a, E e) {
        return 0;
    }

    @Override
    public int sortAndLast(E[] a, E e) {
        return 0;
    }

    @Override
    public int[] sortAndAll(E[] a, E e) {
        return new int[0];
    }

    @Override
    public Stream<E> sortAndAllStream(E[] a, E e) {
        return null;
    }
}
