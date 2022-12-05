package com.monkey.patterntest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyRequest {
    @GET("api/facts")
    Call<DogFacts> getFact();
}
