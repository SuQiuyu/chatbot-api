package com.asu.chatbot.api.test;

import com.alibaba.fastjson.JSON;
import com.asu.chatbot.api.domain.ai.service.OpenAI;
import com.asu.chatbot.api.domain.zsxq.IZsxqApi;
import com.asu.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.asu.chatbot.api.domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;
    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private OpenAI openAI;
    private Logger logger= LoggerFactory.getLogger(SpringBootRunTest.class);
    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果{}", JSON.toJSONString(unAnsweredQuestionsAggregates));
        List<Topics> topics=unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for(Topics topic:topics){
            String topicId= topic.getTopicId();
            String text = topic.getTalk().getText();
            logger.info("topicId: {} text: {}", topicId,text);

            zsxqApi.answer(groupId,cookie,topicId,text,false);
        }
    }

    @Test
    public void test_openAi() throws IOException{
        String response=openAI.doChatGPT("帮我写一个冒泡排序");
        logger.info("测试结果:{}", response);

    }
}
