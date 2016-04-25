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
    @PUT("nodemcu_1")
    Call<MicrogearDao> SendToGear1Controller(@Body RequestBody requestBody);

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @PUT("nodemcu_2")
    Call<MicrogearDao> SendToGear2Controller(@Body RequestBody requestBody);

    @Headers({
            "Authorization: Basic VDIyc2diUHB6azhIQkEzOnBWR1RZNGRsZUpSWjFlcDdhV3RyN2dMNnk="
    })
    @PUT("nodemcu_3")
    Call<MicrogearDao> SendToGear3Controller(@Body RequestBody requestBody);

}
