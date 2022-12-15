package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> aux;
    private List<Integer> result;

    @BeforeEach
    public void setUp() {
        aux = Arrays.asList(1,2,4,2,5);
        result = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4, 5));

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(aux);

        Assertions.assertEquals(result, distinct);
    }

    @Test
    public void bug_deduplicate_8726() {
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2));

        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }
}
