package com.mymacz.smartgarden;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mymacz on 4/21/2016 AD.
 */
public class TopicDao {

    @SerializedName("topic")
    private String topic;
    @SerializedName("payload")
    private String payload;
    @SerializedName("qos")
    private Integer qos;
    @SerializedName("retain")
    private Boolean retain;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }

    public Boolean getRetain() {
        return retain;
    }

    public void setRetain(Boolean retain) {
        this.retain = retain;
    }
}
