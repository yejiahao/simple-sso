package com.sheefee.simple.sso.client.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTPUtil {
    /**
     * 向目标url发送post请求
     *
     * @param url
     * @param entityMap
     * @return String
     * @author yejiahao
     * @date 2018年9月26日 16:25:00
     */
    public static String post(String url, Map<String, String> entityMap) {
        String result = "";
        // 创建httpPost
        HttpPost httppost = new HttpPost(url);
        System.out.println("executing request: " + httppost.getURI());
        // 创建参数队列
        List<NameValuePair> formParams = new ArrayList<>();

        entityMap.forEach((k, v) -> formParams.add(new BasicNameValuePair(k, v)));
        System.out.println("request body: " + formParams);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            httppost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));
            // 执行post请求
            try (CloseableHttpResponse response = httpClient.execute(httppost)) {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    result = EntityUtils.toString(entity, Consts.UTF_8);
                    // 打印响应内容长度
                    System.out.println("response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("response content: " + result);
                }
                System.out.println("--------------------------------------");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    // 测试
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("clientUrl", "httputil");
        post("http://localhost:8080/", params);
    }
}