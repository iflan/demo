package org.usc.demo.singleton;

/**
 *
 * @author Shunli
 */
public class SingletonFactory {
    private SingletonFactory() {

    }

    private static class Holder1 {
        static final Obj1 holder = new Obj1();
        // // if use same holder, once use Holder will init all holder instance.
        // static final Obj2 holder2 = new Obj2();
    }

    private static class Holder2 {
        static final Obj2 holder = new Obj2();
    }

    public static Obj1 getInstance1() {
        return Holder1.holder;
    }

    public static Obj2 getInstance2() {
        return Holder2.holder;
    }
}
