package com.monkey.patterntest;

public interface Contract {

    interface View {
        void showResult(String result);
    }

    interface Model {
        interface OnResponseListener {
            void onResponse(String result);
        }

        void getFact(OnResponseListener listener);
    }

    interface Presenter {
        void onButtonClick();
    }
}
