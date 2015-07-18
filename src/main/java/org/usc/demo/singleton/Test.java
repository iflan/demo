package org.usc.demo.singleton;

import com.google.common.base.Stopwatch;

/**
 *
 * @author Shunli
 */
public class Test {
    private static final Stopwatch sw = Stopwatch.createStarted();

    // private static final Obj obj = new Obj();

    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(sw.toString());

        System.out.println(SingletonFactory.getInstance1());
        System.out.println(SingletonFactory.getInstance1());
        System.out.println(SingletonFactory.getInstance2());
        System.out.println(SingletonFactory.getInstance2());

        System.out.println(SingletonEnumFactory.INSTANCE.getInstance1());
        System.out.println(SingletonEnumFactory.INSTANCE.getInstance1());
        System.out.println(SingletonEnumFactory.INSTANCE.getInstance2());
        System.out.println(SingletonEnumFactory.INSTANCE.getInstance2());

        System.out.println(sw.toString());
    }

}
