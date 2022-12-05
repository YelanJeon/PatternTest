package com.monkey.patterntest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {
    public void getFacts(OnResponse onResponse) {
        MyRetrofit.getInstance().create(MyRequest.class).getFact().enqueue(new Callback<DogFacts>() {
            @Override
            public void onResponse(Call<DogFacts> call, Response<DogFacts> response) {
                onResponse.onResponse(response.body().getFactMessage());
            }

            @Override
            public void onFailure(Call<DogFacts> call, Throwable t) {
                onResponse.onResponse("failure");
            }
        });
    }
}
