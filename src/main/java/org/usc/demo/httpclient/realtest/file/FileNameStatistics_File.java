package org.usc.demo.httpclient.realtest.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 *
 * @author Shunli
 */
public class FileNameStatistics_File {
    public static void main(String[] args) throws IOException {
        List<String> names = Lists.newArrayList();

//        List<String> paths = ImmutableList.of("F:\\Share\\电影\\4K\\0", "E:\\电影\\0");
        List<String> paths = ImmutableList.of("F:\\电影\\movie");

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

        FileUtils.writeLines(new File("D:\\电影\\0", "alls-3.txt"), names);

    }
}
