package com.example.atividade2906;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.example.atividade2906.ui.main.terceira.TerceiraFragment;
import com.example.atividade2906.ui.main.terceira.TerceiraViewModel;

import java.util.ArrayList;

public class TerceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TerceiraFragment.newInstance())
                    .commitNow();
        }

        Intent intent = getIntent();

        ArrayList<Integer> numbers = intent.getIntegerArrayListExtra("NUMBERS");

        Log.d("TerceiraActivity", "onCreate: " + numbers);
        TerceiraViewModel viewModel = new ViewModelProvider(this).get(TerceiraViewModel.class);

        assert numbers != null;
        viewModel.setNumbers(numbers);

        //viewModel.setContext(this);


    }
}