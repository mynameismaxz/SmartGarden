package com.mymacz.smartgarden;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

/**
 * Created by mymacz on 4/19/2016 AD.
 */
public interface MicrogearAPI {

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @PUT("nodemcu")
    Call<MicrogearDao> SendToGearController(@Body RequestBody requestBody);
}
