package com.example.automaticelectricfaultdetectingsystem;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCurrent {

    @GET("?api_key=SF0MOMRXZ2I5VIJH&results=2")
    Call<CurrentFeeds> getCurrentField();
}
