package com.asu.chatbot.api.domain.zsxq.model.req;

public class ReqData {
    private String test;
    private String[] image_ids=new String[]{};
    private boolean silenced;

    public ReqData(String text, boolean silenced) {
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }
}
