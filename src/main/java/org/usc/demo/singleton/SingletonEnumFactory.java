package org.usc.demo.singleton;

/**
 *
 * @author Shunli
 */
public enum SingletonEnumFactory {
    INSTANCE;

    private Obj1 obj1 = new Obj1();
    private Obj2 obj2 = new Obj2();

    public Obj1 getInstance1() {
        return obj1;
    }

    public Obj2 getInstance2() {
        return obj2;
    }

}
