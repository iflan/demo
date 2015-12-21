package org.usc.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Maps;
import com.xunlei.youxi.core.util.FileUtil;

/**
 *
 * @author Shunli
 */
public class BuildSqlStatement23 {

    public static void main(String[] args) throws IOException {
        // List<AccountInfo> results = new ArrayList<AccountInfo>();
        //
        // for (String content : FileUtil.readLines("D://p1.txt")) {
        // String[] split = content.split("\t");
        // results.add(new AccountInfo(split[1], split[2], split[3], split[4]));
        // }
        //
        // List<String> infos = new ArrayList<String>();
        // for (AccountInfo result : results) {
        // infos.add(result.toString());
        // }
        // org.apache.commons.io.FileUtils.writeLines(new File("D://phone.txt"), results);
        // System.out.println("over");

        Map<String, String> map = Maps.newHashMap();

        for (String content : FileUtil.readLines("D://1.txt")) {
            String[] split = content.split(",");
            String userId = split[0];
            if (map.containsKey(userId)) {
                System.out.println("ding:" + content);
            } else {
                map.put(userId, content);
            }
            // results.add(new AccountInfo(split[0], split[1], split[2], split[3]));
        }

    }
}

class AccountInfo {
    private String userId;
    private String loginName;
    private String digitAccount;
    private String phone;

    public AccountInfo() {
    }

    public AccountInfo(String userId, String loginName, String digitAccount, String phone) {
        this.userId = userId;
        this.loginName = loginName;
        this.digitAccount = digitAccount;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getDigitAccount() {
        return digitAccount;
    }

    public void setDigitAccount(String digitAccount) {
        this.digitAccount = digitAccount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
