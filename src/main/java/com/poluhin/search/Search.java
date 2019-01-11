package com.poluhin.search;

import java.util.stream.Stream;

public interface Search<E extends Comparable<E>> {

    int search(E[] a, E e);
    int first(E[] a, E e);
    int last(E[] a, E e);
    int[] all(E[] a, E e);
    Stream<E> allStream(E[] a, E e);

    int sortAndSearch(E[] a, E e);
    int sortAndFirst(E[] a, E e);
    int sortAndLast(E[] a, E e);
    int[] sortAndAll(E[] a, E e);
    Stream<E> sortAndAllStream(E[] a, E e);
}
