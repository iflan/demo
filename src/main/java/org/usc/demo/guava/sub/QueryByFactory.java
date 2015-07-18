package org.usc.demo.guava.sub;

/**
 *
 * @author Shunli
 */
public enum QueryByFactory {
    UID {
        @Override
        public void query() {
        }
    },
    CID {
        @Override
        public void query() {
        }
    };

    public abstract void query();
}
