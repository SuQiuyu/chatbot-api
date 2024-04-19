package com.asu.chatbot.api.domain.zsxq.model.vo;

public class Group
{
    private String groupId;

    private String name;

    private String type;

    private String background_url;

    public void setGroup_id(String groupId){
        this.groupId = groupId;
    }
    public String getGroupId(){
        return this.groupId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setBackground_url(String background_url){
        this.background_url = background_url;
    }
    public String getBackground_url(){
        return this.background_url;
    }
}