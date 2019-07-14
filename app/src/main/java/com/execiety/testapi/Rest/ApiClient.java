package com.execiety.testapi.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    Ini Api Client untuk konfigurasi apinya
    seperti urlnya
*/

public class ApiClient {
    //Base Url Api
    public static final String BASE_URL = "http://103.105.128.123/Apikoperasi/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
