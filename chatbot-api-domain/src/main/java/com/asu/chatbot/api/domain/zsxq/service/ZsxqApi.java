package com.asu.chatbot.api.domain.zsxq.service;

import com.alibaba.fastjson.JSON;
import com.asu.chatbot.api.domain.zsxq.IZsxqApi;
import com.asu.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.asu.chatbot.api.domain.zsxq.model.req.AnswerReq;
import com.asu.chatbot.api.domain.zsxq.model.req.ReqData;
import com.asu.chatbot.api.domain.zsxq.model.res.AnswerRes;
import net.sf.json.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ZsxqApi implements IZsxqApi {
    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);
    @Override
    public UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String grouoId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//        String formattedDateTime = now.format(formatter);
//        formattedDateTime = formattedDateTime.replace(" ", "T");
//        formattedDateTime += "+0800";
//        String encodedDateTime = URLEncoder.encode(formattedDateTime, "UTF-8");
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/"+grouoId+"/topics?scope=all&count=1");
        get.addHeader("cookie",cookie);
        get.addHeader("Content-Type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String jsonStr= EntityUtils.toString(response.getEntity());
            logger.info("拉取作业数据，groupId:{} jsonStr:{}",grouoId,jsonStr);
            return JSON.parseObject(jsonStr, UnAnsweredQuestionsAggregates.class);
        }else {
            throw new RuntimeException("queryUnAnsweredQuestionsTopicId Err Code is"+response.getStatusLine().getStatusCode());
        }

    }

    @Override
    public boolean answer(String grouoId, String cookie, String topicId, String text, boolean silenced) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/groups/"+topicId+"/comments");
        post.addHeader("cookie",cookie);
        post.addHeader("Content-Type","application/json; charset=UTF-8");
        post.addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36 Edg/123.0.0.0");

        //String paramJson="{\"req_data\":{\"type\":\"solution\",\"text\":\"我不会\\n\",\"image_ids\":[],\"file_ids\":[],\"mentioned_user_ids\":[],\"task_id\":1522452115542122}}";
        AnswerReq answerReq=new AnswerReq(new ReqData(text,silenced));
        String paramJson= JSONObject.fromObject(answerReq).toString();
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String jsonStr= EntityUtils.toString(response.getEntity());
            logger.info("完成作业结果，groupId:{} topicId:{} jsonStr:{}",grouoId,topicId,jsonStr);
            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);
            return answerRes.isSucceeded();
        }else {
            throw new RuntimeException("answer Err Code is"+response.getStatusLine().getStatusCode());
        }
    }


}
