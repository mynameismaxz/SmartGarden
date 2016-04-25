package com.mymacz.smartgarden;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by mymacz on 4/21/2016 AD.
 */
public interface TopicAPI {

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @GET("sensor1")
    Call<List<TopicDao>> GetSensor1Status();

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @GET("sensor2")
    Call<List<TopicDao>> GetSensor2Status();

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @GET("sensor3")
    Call<List<TopicDao>> GetSensor3Status();

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @GET("feeder")
    Call<List<TopicDao>> GetFeederStatus();

}
