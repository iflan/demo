package org.usc.demo.guava.sub;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Objects;

/**
 *
 * @author Shunli
 */
public class Info {
    private String uid;
    private String cid;
    private String gid;
    private String name;

    private Info() {
    }

    public static Info newInstance() {
        return new Info();
    }

    public Info(String uid, String cid, String gid, String name) {
        this.uid = uid;
        this.cid = cid;
        this.gid = gid;
        this.name = name;
    }

    public Info withAll(String uid, String cid, String gid, String name) {
        this.uid = uid;
        this.cid = cid;
        this.gid = gid;
        this.name = name;
        return this;
    }

    public Info withUid(String id) {
        this.uid = id;
        return this;
    }

    public Info withCid(String id) {
        this.cid = id;
        return this;
    }

    public Info withGid(String id) {
        this.gid = id;
        return this;
    }

    public Info withName(String name) {
        this.name = name;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public String getCid() {
        return cid;
    }

    public String getGid() {
        return gid;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uid, cid, gid);
        // return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Info other = (Info) obj;
        return Objects.equal(this.uid, other.uid) || Objects.equal(this.cid, other.cid) || Objects.equal(this.gid, other.gid);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
