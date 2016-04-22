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
            "Authorization: Basic MnkzSVBUMkNQTXpMWGZJOjZqMjhXYVpiemJtblY5ekZmZTBLVGVFUTg="
    })
    @GET("light1")
    Call<List<TopicDao>> GetGearStatus();

}
