package com.monkey.patterntest;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
   private MutableLiveData<String> _fact = new MutableLiveData<>();
   public LiveData<String> fact = _fact;

   public void getData() {
      MyRepository repository = new MyRepository();
      repository.getFacts(new OnResponse() {
         public void onResponse(String response) {
            _fact.setValue(response);
         }
      });
   }
}
