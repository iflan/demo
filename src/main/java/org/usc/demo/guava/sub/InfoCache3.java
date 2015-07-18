package org.usc.demo.guava.sub;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class InfoCache3 {
    private static LoadingCache<Pair<QueryBy, String>, Info> cache = CacheBuilder.newBuilder()
            .maximumSize(30000)
            .weakKeys()
            .softValues().build(new CacheLoader<Pair<QueryBy, String>, Info>() {
        @Override
        public Info load(Pair<QueryBy, String> key) throws Exception {
            // System.out.println("load-cache");

            String id = key.getRight();
            switch (key.getLeft()) {
            case UID:
                return new Info(id, "cid", "gid", "name");
            case CID:
                return new Info("uid", id, "gid", "name");
            case GID:
                return new Info("uid", "cid", id, "name");
            }

            return null;
        }
    });

    public static Info getInfo(QueryBy key) {
        try {
            return cache.get(Pair.of(key, key.getId()));
        } catch (Exception e) {
            return null;
        }

    }

}
