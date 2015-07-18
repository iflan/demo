package org.usc.demo.guava.sub;

/**
 *
 * @author Shunli
 */
public class InfoCache2Test {

    public static void main(String[] args) {
        System.out.println(InfoCache2.getInfo(Info.newInstance().withUid("uid")));
        System.out.println(InfoCache2.getInfo(Info.newInstance().withCid("cid")));
        System.out.println(InfoCache2.getInfo(Info.newInstance().withCid("xxx")));

        // Stopwatch sw = Stopwatch.createStarted();
        // for (int i = 0; i < 100000; i++) {
        // InfoCache.getInfo(Info.newInstance().withUid(RandomStringUtils.randomAlphanumeric(10)));
        // }
        //
        // System.out.println(sw.toString());
    }

}
