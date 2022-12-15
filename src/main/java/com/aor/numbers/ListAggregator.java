package com.aor.numbers;

import java.util.List;

/**
 * A utility class that aggregates list of numbers
 * into a single integer using various functions.
 */
public class ListAggregator {

    public Integer sum(List<Integer> list) {
        int sum = 0;

        for (Integer number : list)
            sum += number;

        return sum;
    }

    public Integer max(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (Integer number : list)
            if (number > max)
                max = number;

        return max;
    }

    public Integer min(List<Integer> list) {
        int min = Integer.MAX_VALUE;

        for (Integer number : list)
            if (number < min)
                min = number;

        return min;
    }

    public int distinct(List<Integer> list, GenericListDeduplicator deduplicator) {
        List<Integer> distinct = deduplicator.deduplicate(list);

        return distinct.size();
    }
}