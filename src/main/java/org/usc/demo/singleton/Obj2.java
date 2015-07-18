package org.usc.demo.singleton;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Shunli
 */
public class Obj2 {

    public Obj2() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("init obj2");
    }

}
