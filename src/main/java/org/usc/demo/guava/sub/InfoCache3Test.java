package org.usc.demo.guava.sub;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class InfoCache3Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(InfoCache3.getInfo(QueryBy.CID.withId("cid")));
        System.out.println(InfoCache3.getInfo(QueryBy.UID.withId("uid")));
        System.out.println(InfoCache3.getInfo(QueryBy.GID.withId("gid")));

        TimeUnit.SECONDS.sleep(5);

        Stopwatch sw = Stopwatch.createStarted();
        for (int i = 0; i < 100000000; i++) {
            InfoCache3.getInfo(QueryBy.UID.withId(RandomStringUtils.randomAlphanumeric(10)));
        }

        System.out.println(sw.toString());
    }
}
