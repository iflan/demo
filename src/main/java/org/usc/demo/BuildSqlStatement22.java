package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Splitter;
import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement22 {
    private static final String tpl = "CREATE TABLE `maillog_000082_%d` (" +
            "  `seqid` bigint(20) NOT NULL AUTO_INCREMENT," +
            "  `jobid` bigint(20) DEFAULT '0'," +
            "  `serverid` varchar(10) DEFAULT ''," +
            "  `rolename` varchar(60) DEFAULT '' COMMENT '角色名'," +
            "  `userid` varchar(30) NOT NULL DEFAULT '' COMMENT '用户id'," +
            "  `customerid` varchar(40) NOT NULL DEFAULT '' COMMENT '加密id'," +
            "  `roleid` varchar(64) DEFAULT '' COMMENT '角色id'," +
            "  `roleext` varchar(60) DEFAULT '' COMMENT '角色备用字段'," +
            "  `templateid1` varchar(60) DEFAULT ''," +
            "  `num1` int(11) DEFAULT '0'," +
            "  `bind1` int(1) DEFAULT '0'," +
            "  `templateid2` varchar(60) DEFAULT ''," +
            "  `num2` int(11) DEFAULT '0'," +
            "  `bind2` int(1) DEFAULT '0'," +
            "  `templateid3` varchar(60) DEFAULT ''," +
            "  `num3` int(11) DEFAULT '0'," +
            "  `bind3` int(1) DEFAULT '0'," +
            "  `templateid4` varchar(60) DEFAULT ''," +
            "  `num4` int(11) DEFAULT '0'," +
            "  `bind4` int(1) DEFAULT '0'," +
            "  `templateid5` varchar(60) DEFAULT ''," +
            "  `num5` int(11) DEFAULT '0'," +
            "  `bind5` int(1) DEFAULT '0'," +
            "  `templateid6` varchar(60) DEFAULT ''," +
            "  `num6` int(11) DEFAULT '0'," +
            "  `bind6` int(1) DEFAULT '0'," +
            "  `templateid7` varchar(60) DEFAULT ''," +
            "  `num7` int(11) DEFAULT '0'," +
            "  `bind7` int(1) DEFAULT '0'," +
            "  `resultcode` int(1) DEFAULT '0'," +
            "  `logTime` varchar(19) DEFAULT ''," +
            "  `msg` varchar(255) DEFAULT ''," +
            "  PRIMARY KEY (`seqid`)," +
            "  KEY `NewIndex2` (`jobid`)," +
            "  KEY `NewIndex3` (`serverid`,`rolename`)," +
            "  KEY `serverid` (`serverid`,`roleid`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            results.add(String.format(tpl, i));
        }

        for (String string : results) {
            System.out.println(string);
        }

        // org.apache.commons.io.FileUtils.writeLines(new File("D://monopolyroleinfo_patch.sql"), results);
        // System.out.println("over");
    }
}
