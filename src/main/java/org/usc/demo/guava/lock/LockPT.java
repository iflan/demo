package org.usc.demo.guava.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.usc.demo.lock.SyncLock;
import org.usc.demo.lock.SyncLockUtil;
import org.usc.demo.lock.SyncLockWithAtomicBoolean;
import org.usc.demo.lock.SyncLockWithGuavaCache;

import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class LockPT {
    private static final String key = "TEST";
    private static final int threads = 1;
    private static final int timesPerThread = 1000000;

    public static void main(String[] args) throws Exception {
        final CountDownLatch startSignal = new CountDownLatch(1);

        ExecutorService executorService = Executors.newFixedThreadPool(threads * 5);

        // SyncLock
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        Stopwatch sw1 = Stopwatch.createStarted();
                        for (int j = 0; j < timesPerThread; j++) {
                            String filed = RandomStringUtils.randomAlphabetic(10);

                            SyncLock.lock(key, filed);
                            SyncLock.unlock(key, filed);
                        }

                        System.out.println("SyncLock lock escaped timess(ms): " + sw1.elapsed(TimeUnit.MILLISECONDS));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // SyncLockWithGuavaCache
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        Stopwatch sw1 = Stopwatch.createStarted();
                        for (int j = 0; j < timesPerThread; j++) {
                            String filed = RandomStringUtils.randomAlphabetic(10);

                            SyncLockWithGuavaCache.lock(key, filed);
                            SyncLockWithGuavaCache.unlock(key, filed);
                        }

                        System.out.println("SyncLockWithGuavaCache lock escaped timess(ms): " + sw1.elapsed(TimeUnit.MILLISECONDS));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // SyncLockWithAtomicBoolean
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        Stopwatch sw1 = Stopwatch.createStarted();
                        for (int j = 0; j < timesPerThread; j++) {
                            String filed = RandomStringUtils.randomAlphabetic(10);

                            SyncLockWithAtomicBoolean.lock(key, filed);
                            SyncLockWithAtomicBoolean.unlock(key, filed);
                        }

                        System.out.println("SyncLockWithAtomicBoolean lock escaped timess(ms): " + sw1.elapsed(TimeUnit.MILLISECONDS));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // ListLocker
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        Stopwatch sw1 = Stopwatch.createStarted();
                        for (int j = 0; j < timesPerThread; j++) {
                            String field = RandomStringUtils.randomAlphabetic(10);

                            String words = SyncLockUtil.buildKeyWord(key, field);
                            ListLocker.lock(words);
                            ListLocker.unlock(words);
                        }

                        System.out.println("ListLocker lock escaped timess(ms): " + sw1.elapsed(TimeUnit.MILLISECONDS));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // MapLocker
        for (int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSignal.await();

                        Stopwatch sw1 = Stopwatch.createStarted();
                        for (int j = 0; j < timesPerThread; j++) {
                            String field = RandomStringUtils.randomAlphabetic(10);

                            String words = SyncLockUtil.buildKeyWord(key, field);
                            MapLocker.lock(words);
                            MapLocker.unlock(words);
                        }

                        System.out.println("MapLocker lock escaped timess(ms): " + sw1.elapsed(TimeUnit.MILLISECONDS));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        startSignal.countDown();

        executorService.shutdown();
    }
}
