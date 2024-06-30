package com.example.atividade2906;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.atividade2906.ui.main.segunda.SegundaFragment;
import com.example.atividade2906.ui.main.segunda.SegundaViewModel;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SegundaFragment.newInstance())
                    .commitNow();
        }


        int number = getIntent().getIntExtra("NUMBER", -1);

        SegundaViewModel viewModel = new ViewModelProvider(this).get(SegundaViewModel.class);
        viewModel.setNumber(number);

        viewModel.setContext(this);



    }




}