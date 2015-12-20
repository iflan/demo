package org.usc.demo.data;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.TreeMultimap;

/**
 *
 * @author Shunli
 */
public class DgInstallData {

    public static void main(String[] args) throws Exception {
        Splitter splitter = Splitter.on("\t");
        Joiner joiner = Joiner.on("\t");

        SetMultimap<String, String> map = TreeMultimap.create();

        for (String content : FileUtils.readLines(new File("D:\\install.txt"))) {
            List<String> list = splitter.omitEmptyStrings().splitToList(content);

            String gid = list.get(0);
            String cid = list.get(1);
            String pid = list.get(2);
            String opid = list.get(3);

            map.put(joiner.join(gid, cid, opid), pid);
        }

        System.out.println(joiner.join("游戏Id", "渠道Id", "操作类型","计数"));
        for (Multiset.Entry<String> entry : map.keys().entrySet()) {
            System.out.println(joiner.join(entry.getElement(), entry.getCount()));
        }
    }
}
