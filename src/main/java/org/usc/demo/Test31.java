package org.usc.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Shunli
 */
public class Test31 {
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {

        semaphore.acquire();

        System.out.println(semaphore.tryAcquire());

        TimeUnit.SECONDS.sleep(2);

        semaphore.release();
        System.out.println(semaphore.tryAcquire());
        System.out.println(semaphore.tryAcquire());
    }

}
