package org.usc.demo.guava.sub;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class InfoCache {
    private static LoadingCache<String, Info> uidCache = CacheBuilder.newBuilder().maximumSize(10000).softValues().build(new CacheLoader<String, Info>() {
        @Override
        public Info load(String key) throws Exception {
            // System.out.println("load-uidCache");
            String uid = key;
            return new Info(uid, "cid", "gid", "name");
        }
    });

    private static LoadingCache<String, Info> cidCache = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<String, Info>() {
        @Override
        public Info load(String key) throws Exception {
            System.out.println("load-cidCache");
            String cid = key;
            return new Info("uid", cid, "gid", "name");
        }
    });

    private static LoadingCache<String, Info> gidCache = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<String, Info>() {
        @Override
        public Info load(String key) throws Exception {
            System.out.println("load-gidCache");
            String gid = key;
            return new Info("uid", "cid", gid, "name");
        }
    });

    public static Info getInfo(QueryBy by) {
        try {
            String id = by.getId();
            switch (by) {
            case UID:
                return uidCache.get(id);
            case CID:
                return cidCache.get(id);
            case GID:
                return gidCache.get(id);
            }
        } catch (Exception e) {
        }

        return null;
    }

}
