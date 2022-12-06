package com.monkey.patterntest;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModel extends ViewModel {
   private MutableLiveData<String> _fact = new MutableLiveData<>();
   public LiveData<String> fact = _fact;

   MyRepository repository;

   public MyViewModel(MyRepository repository) {
      this.repository = repository;
   }

   public void getData() {
      repository.getFacts(new OnResponse() {
         @Override
         public void onResponse(String response) {
            _fact.setValue(response);
         }
      });
   }

   static class MyViewModelFactory implements ViewModelProvider.Factory {

      MyRepository repository;

      public MyViewModelFactory(MyRepository repository) {
         this.repository = repository;
      }

      @NonNull
      @Override
      public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         return (T) new MyViewModel(repository);
      }
   }
}
