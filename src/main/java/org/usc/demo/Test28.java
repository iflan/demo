package org.usc.demo;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Shunli
 */
public class Test28 {

    private static final AtomicBoolean runFlag = new AtomicBoolean(true);
    private static final AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        System.out.println(reset(runFlag));
        System.out.println(reset(runFlag));
        System.out.println(reset(runFlag));
        System.out.println(reset(runFlag));

        System.out.println(isRuning(count.get()));
        System.out.println(isRuning(count.incrementAndGet()));
        System.out.println(isRuning(count.incrementAndGet()));
        System.out.println(isRuning(count.incrementAndGet()));
    }

    private static boolean reset(AtomicBoolean runFlag) {
        boolean flag = runFlag.get();
        runFlag.compareAndSet(flag, !flag);

        return runFlag.get();
    }

    private static boolean isRuning(long currentCount) {
        if (currentCount % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
