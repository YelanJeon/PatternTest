package com.monkey.patterntest;

public class Presenter implements Contract.Presenter {

    private Contract.View view;
    private Contract.Model model;

    public Presenter(Contract.View view, Contract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onButtonClick() {
        model.getFact(new Contract.Model.OnResponseListener() {
            @Override
            public void onResponse(String result) {
                view.showResult(result);
            }
        });
    }
}
