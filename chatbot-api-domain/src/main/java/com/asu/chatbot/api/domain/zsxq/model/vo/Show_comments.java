package com.asu.chatbot.api.domain.zsxq.model.vo;

public class Show_comments
{
    private String commentId;

    private String create_time;

    private Owner owner;

    private String text;

    private int likes_count;

    private int rewards_count;

    private boolean sticky;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }
}