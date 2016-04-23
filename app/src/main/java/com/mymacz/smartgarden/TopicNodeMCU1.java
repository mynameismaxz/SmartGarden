package com.mymacz.smartgarden;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by mymacz on 4/23/2016 AD.
 */
public interface TopicNodeMCU1 {

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @GET("sensor1")
    Call<List<TopicDao>> getTopicNodeMCU1();
}
