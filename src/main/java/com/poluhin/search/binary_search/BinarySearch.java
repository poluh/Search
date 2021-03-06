package com.poluhin.search.binary_search;

import com.poluhin.search.Search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    private static final int NOT_FOUND = -1;

    @Override
    public int search(E[] a, E e) {
        return recursionSearch(a, e, 0, a.length - 1);
    }

    private int recursionSearch(E[] a, E e, int start, int end) {
        final var simplePos = simplePositions(a, e, start, end);
        if (simplePos != NOT_FOUND) return simplePos;

        final var middle = (end + start) >>> 1;
        final var cmp = a[middle].compareTo(e);

        if (cmp < 0) return recursionSearch(a, e, start + 1, middle);
        if (cmp > 0) return recursionSearch(a, e, middle, end - 1);
        return middle;
    }

    private int loopSearch(E[] a, E e) {
        var low = 0;
        var high = a.length - 1;

        while (low <= high) {
            var middle = (low + high) >>> 1;
            var cmp = a[middle].compareTo(e);

            if (cmp < 0) low = middle + 1;
            if (cmp > 0) high = middle - 1;
            if (cmp == 0) return middle;
        }
        return -1;
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
        return firstOrLast(a, e, true);
    }

    @Override
    public int last(E[] a, E e) {
        return firstOrLast(a, e, false);
    }

    private int firstOrLast(E[] a, E e, boolean toFirst) {
         var pos = search(a, e);
        final var shift = toFirst ? -1 : 1;
        while (pos >= 0 && pos < a.length && e.equals(a[pos])) {
            pos += shift;
            if (pos < 0 || pos >= a.length) {
                pos += -shift;
                break;
            }
        }
        return pos;
    }

    @Override
    public int[] all(E[] a, E e) {
        var first = first(a, e);
        var last = first;
        while (last < a.length && a[last].equals(e)) {
            last++;
        }
        return IntStream.range(first, last).toArray();
    }

    @Override
    public IntStream allStream(E[] a, E e) {
        return Arrays.stream(all(a, e));
    }

    private E[] getSortCopy(E[] a) {
        return Arrays.copyOf(a, a.length);
    }

    @Override
    public int sortAndSearch(E[] a, E e) {
        return search(getSortCopy(a), e);
    }

    @Override
    public int sortAndFirst(E[] a, E e) {
        return first(getSortCopy(a), e);
    }

    @Override
    public int sortAndLast(E[] a, E e) {
        return last(getSortCopy(a), e);
    }

    @Override
    public int[] sortAndAll(E[] a, E e) {
        return all(getSortCopy(a), e);
    }

    @Override
    public IntStream sortAndAllStream(E[] a, E e) {
        return allStream(getSortCopy(a), e);
    }
}
