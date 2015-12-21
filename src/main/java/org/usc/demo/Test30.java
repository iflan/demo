package org.usc.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.LocalDate;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class Test30 {
    private static final int num = 2000;
    private static final int maxNum = 14000;
    private static final Ordering<Info> dayOrder = Ordering.natural().onResultOf(
            new Function<Info, String>() {
                @Override
                public String apply(Info info) {
                    return info.getDay();
                }
            });

    public static void main(String[] args) {
        Stopwatch sw = Stopwatch.createStarted();
        List<Info> infos = Lists.newArrayList(new Info("2015-05-15", 4000), new Info("2015-05-01", 1000));
        // System.out.println("y = " + calcY(ImmutableList.<Test30.Info> of()));
        System.out.println("y = " + calcY(dayOrder.sortedCopy(infos)));

        System.out.println(sw.elapsed(TimeUnit.MILLISECONDS));

    }

    private static int calcY(List<Info> sortedInfos) {
        if (sortedInfos == null || sortedInfos.isEmpty()) {
            return num;
        }

        LocalDate today = new LocalDate(2015, 5, 20);

        Info first = sortedInfos.get(0);
        int y = 0;
        for (LocalDate day = LocalDate.parse(first.getDay()); !day.isAfter(today); day = day.plusDays(1)) {
            final String dayStr = day.toString();
            Optional<Info> tryFind = Iterables.tryFind(sortedInfos, new Predicate<Info>() {
                @Override
                public boolean apply(Info input) {
                    return StringUtils.equals(input.getDay(), dayStr);
                }
            });

            int consume = tryFind.isPresent() ? tryFind.get().getConsume() : 0;

            // Predicate<Info> predicate = new Predicate<Info>() {
            // @Override
            // public boolean apply(Info input) {
            // return StringUtils.equals(input.getDay(), dayStr);
            // }
            // };
            //
            // int consume = Iterables.find(sortedInfos, predicate, new Info(dayStr, 0)).getConsume();
            int temp = Ints.min(maxNum, y + num);
            y = Ints.max(0, temp - consume);

            System.out.println(day + " = " + temp + " ==> " + y);
        }

        return y;
    }

    static class Info {
        private String day;
        private int consume;

        public Info(String day, int consume) {
            this.day = day;
            this.consume = consume;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getConsume() {
            return consume;
        }

        public void setConsume(int consume) {
            this.consume = consume;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

}
