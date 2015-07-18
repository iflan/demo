package org.usc.demo.guava.sub;

import org.apache.commons.lang3.StringUtils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author Shunli
 */
public class InfoCache2 {
    private static LoadingCache<Info, Info> cache = CacheBuilder.newBuilder().build(
            new CacheLoader<Info, Info>() {
                @Override
                public Info load(Info key) throws Exception {
                    // System.out.println("getCache:" + key);

                    if (StringUtils.isNotEmpty(key.getUid())) {
                        String uid = key.getUid();
                        return key.withAll(uid, "cid", "gid", "name");
                    }

                    if (StringUtils.isNotEmpty(key.getCid())) {
                        String cid = key.getCid();
                        return key.withAll("uid", cid, "gid", "name");
                    }

                    if (StringUtils.isNotEmpty(key.getGid())) {
                        String gid = key.getGid();
                        return key.withAll("uid", "cid", gid, "name");
                    }

                    return null;
                }
            });

    public static Info getInfo(final Info info) {
        try {
            // Optional<Info> tryFind = Iterables.tryFind(cache.asMap().values(), new Predicate<Info>() {
            // @Override
            // public boolean apply(Info input) {
            // return input.equals(info);
            // }
            // });
            //
            // return tryFind.isPresent() ? tryFind.get() : cache.get(info);
            System.out.println(cache.asMap());
            return cache.get(info);
        } catch (Exception e) {
            return null;
        }
    }

}
