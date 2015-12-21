package org.usc.demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.ImmutableTable;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement27 {
    public static void main(String[] args) throws IOException {
        ImmutableTable.Builder<String, String, String> builder = ImmutableTable.builder();

        for (String card : FileUtils.readLines(new File("D://dg_cards.txt"))) {
            String[] split = card.split("\t");

        }

        long num = 115555l;
        long calc = num % 240;


        // org.apache.commons.io.FileUtils.writeLines(new File("D://dg_reservation.txt"), contents);
        System.out.println("end");
    }

}
