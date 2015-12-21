package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement26 {
    public static void main(String[] args) throws IOException {
        Map<String, String> rechargeMap = Maps.newHashMap();

        for (String line : FileUtil.readLines("D://dg_recharge.txt")) {
            String[] split = line.split("\t");

            rechargeMap.put(split[0], split[1]);
        }

        List<String> contents = Lists.newArrayList();
        for (String line : FileUtil.readLines("D://dg_user.txt")) {
            contents.add(line + "\t" + Objects.firstNonNull(rechargeMap.get(line), "0.0000"));
        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://dg_recall.txt"), contents);
        System.out.println("end");
    }

}
