package com.example.atividade2906.ui.main.segunda;

import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.atividade2906.R;
import com.example.atividade2906.TerceiraActivity;

public class SegundaFragment extends Fragment {

    private SegundaViewModel mViewModel;
    private AppCompatButton startButton;
    private TextView numberTextView, totalNumbersTextView;
    public static SegundaFragment newInstance() {
        return new SegundaFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SegundaViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segunda, container, false);

        mViewModel = new ViewModelProvider(requireActivity()).get(SegundaViewModel.class);

        numberTextView = view.findViewById(R.id.numberTextView);
        totalNumbersTextView = view.findViewById(R.id.totalNumbersTextView);

        totalNumbersTextView.setText("Total de números : "+ mViewModel.getNumber());

        mViewModel.setListener(new SegundaViewModel.NumberUpdateListener() {
            @Override
            public void onNumberUpdate(int number) {
                numberTextView.setText(String.valueOf(number));
            }
        });

        mViewModel.startDisplayingNumbers();

        startButton = view.findViewById(R.id.confirmButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SegundaFragment", "onClick: " + mViewModel.getRandomNumbers());
                // Iniciar TerceiraActivity
                Intent intent = new Intent(getActivity(), TerceiraActivity.class);
                intent.putIntegerArrayListExtra("NUMBERS",  mViewModel.getRandomNumbers());
                startActivity(intent);
            }
        });

        return view;
    }

}