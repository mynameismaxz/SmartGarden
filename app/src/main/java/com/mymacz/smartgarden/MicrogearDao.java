package com.mymacz.smartgarden;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mymacz on 4/19/2016 AD.
 */
public class MicrogearDao {

    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
