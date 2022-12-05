package com.monkey.patterntest;

public interface Contract {

    interface View {
        void showResult(String result);
    }

    interface Presenter {
        void getFact();
    }
}
