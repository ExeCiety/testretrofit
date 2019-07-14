package com.execiety.testapi.Model.Login;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
    Ini Model Buat Login
*/

public class Login {

    //Deklarasi Data Di api login

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("error")
    @Expose
    private Boolean error;

    @SerializedName("data")
    @Expose
    private List<DataLogin> data = null;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("TimeZone")
    @Expose
    private String timeZone;

    @SerializedName("Time request")
    @Expose
    private String timeRequest;

    //Ngambil Data di api login
    public Integer getStatus() {
        return status;
    }

    //Set Data di api login
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    //Karena data (liat di postman) itu array object jadi harus di list in dulu
    public List<DataLogin> getData() {
        return data;
    }

    public void setData(List<DataLogin> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(String timeRequest) {
        this.timeRequest = timeRequest;
    }
}
