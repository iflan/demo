package org.usc.demo.singleton;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Shunli
 */
public class Obj1 {

    public Obj1() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("init obj1");
    }

}
