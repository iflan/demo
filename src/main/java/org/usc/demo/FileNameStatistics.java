package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 *
 * @author Shunli
 */
public class FileNameStatistics {
    public static void main(String[] args) throws IOException {
        boolean offline = true;

        List<String> names = Lists.newArrayList();
        names.addAll(FileUtils.readLines(new File("D:\\电影\\0", "all-deletes.txt")));

        List<String> paths = ImmutableList.of("D:\\电影", "E:\\电影\\0", "F:\\Share\\电影\\4K\\0");
        if (offline) {
            names.addAll(FileUtils.readLines(new File("D:\\电影\\0", "alls.txt")));
            paths = paths.subList(0, 1);
        }

        for (String path : paths) {
            try {
                Iterator<File> iterateFiles = FileUtils.iterateFiles(new File(path), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

                while (iterateFiles.hasNext()) {
                    String name = iterateFiles.next().getName();

                    List<String> splitToList = Splitter.on(CharMatcher.is('.')).splitToList(name);

                    names.add(splitToList.get(0));
                }

                System.out.println("success handle " + path);
            } catch (Exception e) {
            }
        }

        System.out.println("");

        Formatter f = new Formatter(System.out);

        List<String> sortedCopy = Ordering.natural().sortedCopy(names);
        for (int i = 0; i < sortedCopy.size() - 1; i++) {
            String left = sortedCopy.get(i);
            String right = sortedCopy.get(i + 1);
            String leftLowerCase = StringUtils.lowerCase(left);
            String rightLowerCase = StringUtils.lowerCase(right);

            int levenshteinDistance = StringUtils.getLevenshteinDistance(leftLowerCase, rightLowerCase);
            String commonPrefix = StringUtils.getCommonPrefix(leftLowerCase, rightLowerCase);

            if (commonPrefix.length() > 20 || levenshteinDistance <= 0) {
                f.format("%-50s %-50s %-10s %-50s\n", left, right, levenshteinDistance, commonPrefix);
            }
        }

        f.close();
    }
}
