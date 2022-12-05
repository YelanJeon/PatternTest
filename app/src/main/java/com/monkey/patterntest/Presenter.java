package com.monkey.patterntest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.Presenter {

    private Contract.View view;

    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void getFact() {
        MyRetrofit.getInstance().create(MyRequest.class).getFact().enqueue(new Callback<DogFacts>() {
            @Override
            public void onResponse(Call<DogFacts> call, Response<DogFacts> response) {
                view.showResult(response.body().getFactMessage());
            }

            @Override
            public void onFailure(Call<DogFacts> call, Throwable t) {
                view.showResult("failure");
            }
        });
    }
}
