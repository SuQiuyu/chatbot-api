package com.asu.chatbot.api.test;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.json.JSONObject;
import com.google.common.net.MediaType;
import okhttp3.*;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class Apitest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie","zsxqsessionid=ff5566a023d2f77b0a6fae29509f9416; tfstk=fu9otwxvXQ55hAqKrKXSnPYvZklAPz6CGeedJ9QEgZ7byyKU9wrevZpRy3BPxy89JM7yJTUnKEXPOQQdywXHAFmxWAH9V36CQV3tBISMYCW_z7WUJ-SVba01-Yk9V3ZqzK2OtAFHwZ-i-w8FaZyVvZyUUeSe0mjFvzPUUe-qmM_4LWyPLoPVvGerg1GPPpJ23cZ4dnfBRSvNq_b3ptehdKwOTNSFuJueng0F7370LJb55GZvm33uCnBWpFj9yxykSH-6Tsv3uVbBnnJyTnao-TxvPdXyI42RDt_R_B5m4Y-cEafHKskKPTAePpfWZki60T8X1N1rGqsDedCh5s4qznKcz1AHyqwFyCx2o1pYkRBw1Evh_OSPvSPNdTyC0Dp4OW1Pcib_Cn8zVS6gd6imm5oCais5Wmm0OW1PcibtmmVZN_SfVNC..; zsxq_access_token=B8C47CF9-06FC-2A2A-08A3-2ABBDF922E3E_03FAA8385138DB65; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812852141524442%22%2C%22first_id%22%3A%2218ee5f759365fb-00e3c4294c10036-4c657b58-1327104-18ee5f7593772c%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlZTVmNzU5MzY1ZmItMDBlM2M0Mjk0YzEwMDM2LTRjNjU3YjU4LTEzMjcxMDQtMThlZTVmNzU5Mzc3MmMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTI4NTIxNDE1MjQ0NDIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812852141524442%22%7D%2C%22%24device_id%22%3A%2218ee5f7691ce95-03fbc937d5dc2e6-4c657b58-1327104-18ee5f7691dda0%22%7D; abtest_env=product");
        get.addHeader("Content-Type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res= EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/5122511245455124/comments");
        post.addHeader("cookie","zsxqsessionid=ff5566a023d2f77b0a6fae29509f9416; abtest_env=product; tfstk=fu9otwxvXQ55hAqKrKXSnPYvZklAPz6CGeedJ9QEgZ7byyKU9wrevZpRy3BPxy89JM7yJTUnKEXPOQQdywXHAFmxWAH9V36CQV3tBISMYCW_z7WUJ-SVba01-Yk9V3ZqzK2OtAFHwZ-i-w8FaZyVvZyUUeSe0mjFvzPUUe-qmM_4LWyPLoPVvGerg1GPPpJ23cZ4dnfBRSvNq_b3ptehdKwOTNSFuJueng0F7370LJb55GZvm33uCnBWpFj9yxykSH-6Tsv3uVbBnnJyTnao-TxvPdXyI42RDt_R_B5m4Y-cEafHKskKPTAePpfWZki60T8X1N1rGqsDedCh5s4qznKcz1AHyqwFyCx2o1pYkRBw1Evh_OSPvSPNdTyC0Dp4OW1Pcib_Cn8zVS6gd6imm5oCais5Wmm0OW1PcibtmmVZN_SfVNC..; zsxq_access_token=B8C47CF9-06FC-2A2A-08A3-2ABBDF922E3E_03FAA8385138DB65; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812852141524442%22%2C%22first_id%22%3A%2218ee5f759365fb-00e3c4294c10036-4c657b58-1327104-18ee5f7593772c%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlZTVmNzU5MzY1ZmItMDBlM2M0Mjk0YzEwMDM2LTRjNjU3YjU4LTEzMjcxMDQtMThlZTVmNzU5Mzc3MmMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTI4NTIxNDE1MjQ0NDIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812852141524442%22%7D%2C%22%24device_id%22%3A%2218ee5f7691ce95-03fbc937d5dc2e6-4c657b58-1327104-18ee5f7691dda0%22%7D");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson="{\"req_data\":{\"type\":\"solution\",\"text\":\"我不会\\n\",\"image_ids\":[],\"file_ids\":[],\"mentioned_user_ids\":[],\"task_id\":1522452115542122}}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res= EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        String pro = "127.0.0.1";//本机地址
        int pro1 = 7890; //代理端口号
        //创建一个 HttpHost 实例，这样就设置了代理服务器的主机和端口。
        HttpHost httpHost = new HttpHost(pro, pro1);
        //创建一个 RequestConfig 对象，然后使用 setProxy() 方法将代理 httpHost 设置进去。
        RequestConfig build = RequestConfig.custom().setProxy(httpHost).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.chatanywhere.tech/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer sk-NbolP7aYNkhoma3QmBquZAxc5TlGZ3Cco89dtRHhdoZLBnXc");
        post.addHeader("User-Agent", "Apifox/1.0.0 (https://apifox.com)");
        //将 build 配置设置到 post 请求中包括先前指定的代理设置。
        post.setConfig(build);
        String paramJson = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"写一个冒泡排序\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }


}
