package org.usc.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement24 {
    private static final String tpl = "{question:'%s',answers:['%s','%s','%s','%s']},";

    private static String trim(String string) {
        return StringUtils.trim(string);
    }

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<String>();

        for (String content : FileUtil.readLines("D://200.txt")) {
            String[] split = content.split("\t");
            // System.out.println(Arrays.toString(split));
            // System.out.println(split.length);
            // System.out.println(Arrays.toString(content.split("\t")));
            try {
                results.add(String.format(tpl, trim(split[0]), trim(split[1]), trim(split[2]), trim(split[3]), trim(split[4])));
            } catch (Exception e) {
                System.out.println(content);
            }
        }

        for (String string : results) {
            System.out.println(string);
        }

        // org.apache.commons.io.FileUtils.writeLines(new File("D://monopolyroleinfo_patch.sql"), results);
        // System.out.println("over");
    }
}
