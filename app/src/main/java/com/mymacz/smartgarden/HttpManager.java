package com.mymacz.smartgarden;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mymacz on 4/19/2016 AD.
 */
public class HttpManager {

    private static HttpManager instance;
    private MicrogearAPI micApi;

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
    }

    public MicrogearAPI getMicApi() {
        return micApi;
    }
}
