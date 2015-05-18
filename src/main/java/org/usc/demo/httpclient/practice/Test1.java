package org.usc.demo.httpclient.practice;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author Shunli
 */
public class Test1 {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Request.Get("http://freeapi.ipip.net/118.28.8.8").execute().returnContent().asString());
        }
    }
}
