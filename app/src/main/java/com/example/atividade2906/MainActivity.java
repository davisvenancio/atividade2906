package com.example.atividade2906;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText numberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numberInput = findViewById(R.id.numberInput);
        AppCompatButton confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberString = numberInput.getText().toString();

                if(!numberString.isEmpty()){
                    int number = Integer.parseInt(numberString);
                    callSecondPage(number);
                    //Toast.makeText(MainActivity.this, "Número inserido: " + number, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Por favor, insira um número ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void callSecondPage(int number) {
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        intent.putExtra("NUMBER", number);
        startActivity(intent);
    }
}