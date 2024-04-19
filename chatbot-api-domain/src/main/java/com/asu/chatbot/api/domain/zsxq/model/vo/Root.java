package com.asu.chatbot.api.domain.zsxq.model.vo;

import com.asu.chatbot.api.domain.zsxq.model.res.RespData;

public class Root
{
    private boolean succeeded;

    private RespData respData;


    public RespData getRespData() {
        return respData;
    }

    public void setRespData(RespData respData) {
        this.respData = respData;
    }

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
    public boolean getSucceeded(){
        return this.succeeded;
    }
}
