package com.asu.chatbot.api.domain.zsxq;

import com.asu.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * 知识星球Api接口
 */
public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String grouoId, String cookie) throws IOException;
    boolean answer(String grouoId, String cookie,String topicId, String text,boolean silenced) throws IOException;

}
