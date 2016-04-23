package com.mymacz.smartgarden;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mymacz on 4/19/2016 AD.
 */
public class HttpManager {

    private static HttpManager instance;
    private MicrogearAPI micApi;
    private TopicAPI topicAPI;
    private TopicNodeMCU1 topicNodeMCU1;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private HttpManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.netpie.io/microgear/KMUTTSmartGarden/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        micApi = retrofit.create(MicrogearAPI.class);

        Retrofit topicCall = new Retrofit.Builder()
                .baseUrl("https://api.netpie.io/topic/MacSmartHome/smarthome/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        topicAPI = topicCall.create(TopicAPI.class);

        Retrofit topicMCU1 = new Retrofit.Builder()
                .baseUrl("https://api.netpie.io/topic/KMUTTSmartGarden/nodemcu_1/sensor/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        topicNodeMCU1 = topicMCU1.create(TopicNodeMCU1.class);

    }

    public MicrogearAPI getMicApi() {
        return micApi;
    }

    public TopicAPI getTopicAPI() {
        return topicAPI;
    }

    public TopicNodeMCU1 getTopicNodeMCU1() {
        return topicNodeMCU1;
    }
}

