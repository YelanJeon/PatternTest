package com.monkey.patterntest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyRetrofit.getInstance().create(MyRequest.class).getFact().enqueue(new Callback<DogFacts>() {
                    @Override
                    public void onResponse(Call<DogFacts> call, Response<DogFacts> response) {
                        textView.setText(response.body().getFactMessage());
                    }

                    @Override
                    public void onFailure(Call<DogFacts> call, Throwable t) {
                        textView.setText("failure");
                    }
                });
            }
        });
    }
}