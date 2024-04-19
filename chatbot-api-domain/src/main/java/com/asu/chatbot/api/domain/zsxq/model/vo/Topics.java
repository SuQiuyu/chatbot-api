package com.asu.chatbot.api.domain.zsxq.model.vo;

import java.util.List;

public class Topics
{
    private String topicId;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public List<Show_comments> getShow_comments() {
        return show_comments;
    }

    public void setShow_comments(List<Show_comments> show_comments) {
        this.show_comments = show_comments;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getRewards_count() {
        return rewards_count;
    }

    public void setRewards_count(int rewards_count) {
        this.rewards_count = rewards_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getReading_count() {
        return reading_count;
    }

    public void setReading_count(int reading_count) {
        this.reading_count = reading_count;
    }

    public int getReaders_count() {
        return readers_count;
    }

    public void setReaders_count(int readers_count) {
        this.readers_count = readers_count;
    }

    public boolean isDigested() {
        return digested;
    }

    public void setDigested(boolean digested) {
        this.digested = digested;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public User_specific getUser_specific() {
        return user_specific;
    }

    public void setUser_specific(User_specific user_specific) {
        this.user_specific = user_specific;
    }

    private Group group;

    private String type;

    private Talk talk;

    private List<Show_comments> show_comments;

    private int likes_count;

    private int rewards_count;

    private int comments_count;

    private int reading_count;

    private int readers_count;

    private boolean digested;

    private boolean sticky;

    private String create_time;

    private User_specific user_specific;

}