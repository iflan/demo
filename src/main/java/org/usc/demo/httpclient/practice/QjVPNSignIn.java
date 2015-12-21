package org.usc.demo.httpclient.practice;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 *
 * @author Shunli
 */
public class QjVPNSignIn {
    // private static final String URL = "http://www.zimuzu.tv/";
    private static final String LOGIN_URL = "http://www.qjvpn.com.cn/user/checklogin.php";
    // private static final String SIGN_IN_PAGE_URL = "http://www.zimuzu.tv/user/sign";
    private static final String SIGN_IN_URL = "http://www.qjvpn.com.cn/ajax2.php?fun=sign";

    public static void main(String[] args) {
        List<Account> accounts = ImmutableList.of(
                new Account("jsjmz", "lishunli")
                );

        for (Account account : accounts) {
            try {
                Executor executor = Executor.newInstance().cookieStore(new BasicCookieStore());
                if (login(executor, account)) {
                    signIn(executor, account);
                }
            } catch (Exception e) {
                System.out.println("【" + account.getUsrename() + "】签到异常");
            }

        }
    }

    private static boolean login(Executor executor, Account account) throws ClientProtocolException, IOException {
        String usrename = account.getUsrename();

        List<NameValuePair> formParams = Lists.newArrayList();
        formParams.add(new BasicNameValuePair("username", usrename));
        formParams.add(new BasicNameValuePair("password", account.getPassword()));
        formParams.add(new BasicNameValuePair("from", ""));

        executor.execute(Request.Post(LOGIN_URL).bodyForm(formParams));

        // // if check login state please load center page first.
        // String loginJson = executor.execute(Request.Get("http://www.qjvpn.com.cn/user/center.php")).returnContent().asString();

        System.out.println("【" + usrename + "】登录成功");
        return true;
    }

    private static boolean signIn(Executor executor, Account account) throws ClientProtocolException, IOException {
        String usrename = account.getUsrename();

        String stauts = executor.execute(Request.Get(SIGN_IN_URL)).returnContent().asString();
        if ("0".equals(stauts)) {
            System.out.println("【" + usrename + "】已经签到");
            return true;
        }

        if ("1".equals(stauts)) {
            System.out.println("【" + usrename + "】签到成功");
            return true;
        }

        System.out.println("【" + usrename + "】签到失败：" + stauts);
        return false;
    }

    static class Account {
        private String usrename;
        private String password;

        public Account(String usrename, String password) {
            this.usrename = usrename;
            this.password = password;
        }

        public String getUsrename() {
            return usrename;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }
}
