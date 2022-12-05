package com.monkey.patterntest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogFacts implements Contract.Model{

    @SerializedName("facts")
    List<String> facts;

    public String getFactMessage() {
        if(facts == null) {
            return "list is null";
        }else{
            return facts.get(0);
        }
    }

    @Override
    public void getFact(OnResponseListener listener) {
        MyRetrofit.getInstance().create(MyRequest.class).getFact().enqueue(new Callback<DogFacts>() {
            @Override
            public void onResponse(Call<DogFacts> call, Response<DogFacts> response) {
                listener.onResponse(response.body().getFactMessage());
            }

            @Override
            public void onFailure(Call<DogFacts> call, Throwable t) {
                listener.onResponse("failure");
            }
        });
    }
}
