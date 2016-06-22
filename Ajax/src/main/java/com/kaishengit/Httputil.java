package com.kaishengit;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;


public class Httputil {

    public static String  httpClient(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
           HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpCode = httpResponse.getStatusLine().getStatusCode();
            if (httpCode == 200) {

                InputStream inputStream = httpResponse.getEntity().getContent();
                String html = IOUtils.toString(inputStream);
                return html;
            }else{
                throw new RuntimeException("服务器异常"+httpCode);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
