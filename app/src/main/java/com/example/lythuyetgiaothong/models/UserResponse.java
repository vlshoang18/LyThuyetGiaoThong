package com.example.lythuyetgiaothong.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {@SerializedName("status")
@Expose
private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("id")
    @Expose
    private String id;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
