package com.monkey.patterntest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//레트로핏 싱글톤 구현
public class MyRetrofit {
    private final static String baseURL = "http://dog-api.kinduff.com/";

    private MyRetrofit() {}

    public static Retrofit getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
