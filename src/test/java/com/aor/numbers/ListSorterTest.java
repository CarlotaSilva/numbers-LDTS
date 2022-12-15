package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    private List<Integer> aux;
    private List<Integer> result;

    @BeforeEach
    public void setUp() {
        aux = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        result = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    public void sort() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(aux);

        Assertions.assertEquals(result, sorted);
    }

    @Test
    public void bug_sort_8276() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(Arrays.asList(1, 2, 4, 2));

        Assertions.assertEquals(Arrays.asList(1, 2, 2, 4), sorted);
    }
}
