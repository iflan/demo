package org.usc.demo.guava.sub;

/**
 *
 * @author Shunli
 */
public enum QueryBy {
    UID,
    CID,
    GID;

    private String id;

    public String getId() {
        return id;
    }

    public QueryBy withId(String id) {
        this.id = id;
        return this;
    }

}
