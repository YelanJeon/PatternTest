package com.monkey.patterntest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogFacts {
    @SerializedName("facts")
    List<String> facts;

    public String getFactMessage() {
        if(facts == null) {
            return "list is null";
        }else{
            return facts.get(0);
        }
    }
}
