package com.kekegdsz.apploadingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kekegdsz.view.LoadingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadingView loadingView =findViewById(R.id.loading_view);
    }
}
