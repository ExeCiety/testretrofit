package com.execiety.testapi.Rest;

import com.execiety.testapi.Model.Login.Login;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/*
    Ini Api Interface
    Pada ApiInterface terdapat metode-metode yang akan digunakan dalam komunikasi data dengan Rest
    server serta atribut-atribut yang digunakan dalam komunikasi data tersebut.
*/

public interface ApiInterface {

    //Ini Untuk Request body form-data
    @Multipart
    //Url nya jadi http://103.105.128.123/Apikoperasi/User/getlogin
    @POST("User/getlogin")
    //@Part username sama password itu nama key request liat di postman
    //pake RequestBody karena apinya minta form-data
    //Info Lebih Lanjut : https://square.github.io/retrofit/
    Call<Login> Login_User(@Part("username") RequestBody username, @Part("password") RequestBody password);
}
