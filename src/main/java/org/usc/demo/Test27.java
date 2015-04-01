package org.usc.demo;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 *
 * @author Shunli
 */
public class Test27 {
    private static final List<Integer> commonGifts = Lists.newArrayList(100, 200, 300, 400, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000);
    private static final RangeMap<Integer, Integer> rangeMap = TreeRangeMap.create();

    static {
        for (Integer gift : Ordering.natural().sortedCopy(commonGifts)) {
            rangeMap.put(Range.atLeast(gift), gift);
        }

    }

    public static void main(String[] args) {
        int base = 100;
        for (int i = 1; i <= 1000; i++) {
            int value = base * i;
            System.out.println(value + " ==> " + split(value));
        }
    }

    private static List<Integer> split(int ccy) {
        List<Integer> splits = Lists.newArrayList();

        while (rangeMap.get(ccy) != null) {
            Integer split = rangeMap.get(ccy);
            ccy -= split;

            splits.add(split);
        }
        return splits;
    }

}
