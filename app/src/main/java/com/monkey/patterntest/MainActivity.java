package com.monkey.patterntest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.monkey.patterntest.databinding.ActivityMainBinding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyViewModel.MyViewModelFactory factory = new MyViewModel.MyViewModelFactory(new MyRepository(getBaseRetrofit()));
        viewModel = new ViewModelProvider(this, factory).get(MyViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

    }

    private Retrofit getBaseRetrofit() {
        return  new Retrofit.Builder()
                .baseUrl("http://dog-api.kinduff.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}