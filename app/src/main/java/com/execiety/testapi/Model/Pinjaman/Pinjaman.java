package com.execiety.testapi.Model.Pinjaman;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pinjaman {
    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("error")
    @Expose
    private Boolean error;

    @SerializedName("data")
    @Expose
    private List<DataPinjaman> data = null;

    @SerializedName("TimeZone")
    @Expose
    private String timeZone;

    @SerializedName("Time request")
    @Expose
    private String timeRequest;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<DataPinjaman> getData() {
        return data;
    }

    public void setData(List<DataPinjaman> data) {
        this.data = data;
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
