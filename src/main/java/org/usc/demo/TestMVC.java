package org.usc.demo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;

/**
 *
 * @author Shunli
 */
public class TestMVC {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        // System.out.println(Request.Get("http://localhost:8080/quickstart/api/v1/task").execute().returnContent().asString());

        for (int i = 10; i < 100; i++) {
            String json = "{\"title\":\"test" + i + "\",\"description\":\"test" + i + "\",\"user\":{\"id\":3}}";
            Response execute = Request.Post("http://localhost:8080/quickstart/api/v1/task").bodyString(json, ContentType.APPLICATION_JSON).execute();
            System.out.println(execute.returnResponse().getStatusLine());
        }
    }

}
