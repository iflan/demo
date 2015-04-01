package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement21 {
    public static void main(String[] args) throws IOException {

        List<String> results = new ArrayList<String>();

        List<String> readLines = FileUtil.readLines("D://1.txt");
        for (String ipStr : FileUtil.readLines("D://ips.txt")) {
            String matchIp = StringUtils.trim(ipStr);

            for (String line : readLines) {
                String[] s = line.split(",");

                // String userId = s[1];
                // String loginName = s[2];

                String ip = s[8];
                if (StringUtils.equals(matchIp, ip)) {
                    results.add(line);
                    // System.out.println(line);
                }

                // System.out.println(new SurveyActivation(NumberUtils.toLong(s[0]), s[1], s[2], s[3],
                // NumberUtils.toInt(s[4]), s[5], s[6], NumberUtils.toLong(s[7]), ip));
            }

            System.out.println("success handle: " + matchIp);
        }

        org.apache.commons.io.FileUtils.writeLines(new File("D://results.txt"), results);
        System.out.println("over");
    }
}

//class SurveyActivation {
//    private Long seqId;
//    private String userId;
//    private String oldAccount;
//    private String digitalAccount;
//    private Integer flag;
//    private String inputTime;
//    private String updateTime;
//    private Long updateTimestamp;
//    private String ip;
//
//    public SurveyActivation(Long seqId, String userId, String oldAccount, String digitalAccount, Integer flag, String inputTime, String updateTime, Long updateTimestamp, String ip) {
//        this.seqId = seqId;
//        this.userId = userId;
//        this.oldAccount = oldAccount;
//        this.digitalAccount = digitalAccount;
//        this.flag = flag;
//        this.inputTime = inputTime;
//        this.updateTime = updateTime;
//        this.updateTimestamp = updateTimestamp;
//        this.ip = ip;
//    }
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
//    }
//}
