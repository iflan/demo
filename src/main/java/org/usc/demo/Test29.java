package org.usc.demo;

import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.ISODateTimeFormat;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class Test29 {
    public static void main(String[] args) {
        List<String> signIns = Lists.newArrayList("2015-04-21", "2015-04-22", "2015-04-23", "2015-04-25", "2015-04-26", "2015-04-27", "2015-04-28");
        List<String> sortedSignIns = Ordering.natural().sortedCopy(signIns);

        int max = getContinuousDays(sortedSignIns);

        System.out.println(max);
    }

    private static int getContinuousDays(List<String> sortedSignIns) {
        int size = Iterables.size(sortedSignIns);
        int count = Ints.min(1, size);
        int max = count;
        for (int i = 0; i < size - 1; i++) {
            LocalDate now = getLocalDate(Iterables.get(sortedSignIns, i));
            LocalDate next = getLocalDate(Iterables.get(sortedSignIns, i + 1));
            if (Days.daysBetween(now, next).equals(Days.ONE)) {
                count++;
                max = Ints.max(max, count);
            } else {
                count = 1;// reset
            }
        }
        return max;
    }

    private static LocalDate getLocalDate(String day) {
        return ISODateTimeFormat.date().parseLocalDate(day);
    }
}
