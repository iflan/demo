package org.usc.demo.guava.sub;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class InfoCacheTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(InfoCache.getInfo(QueryBy.CID.withId("cid")));
        System.out.println(InfoCache.getInfo(QueryBy.UID.withId("uid")));
        System.out.println(InfoCache.getInfo(QueryBy.GID.withId("gid")));

        TimeUnit.SECONDS.sleep(5);

        Stopwatch sw = Stopwatch.createStarted();
        for (int i = 0; i < 500000000; i++) {
            InfoCache.getInfo(QueryBy.UID.withId(RandomStringUtils.randomAlphanumeric(10)));
        }

        System.out.println(sw.toString());
    }
}
