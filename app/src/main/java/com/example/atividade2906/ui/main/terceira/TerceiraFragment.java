package com.example.atividade2906.ui.main.terceira;

import androidx.lifecycle.ViewModelProvider;

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


public class TerceiraFragment extends Fragment {

    private TerceiraViewModel mViewModel;
    private TextView numbersTextView;

    public static TerceiraFragment newInstance() {
        return new TerceiraFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TerceiraViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terceira, container, false);
        mViewModel = new ViewModelProvider(this).get(TerceiraViewModel.class);
        numbersTextView = view.findViewById(R.id.numbersTextView);
        Log.d("TerceiraFragment", "onCreateView: " + mViewModel.getRandomNumbers());
        numbersTextView.setText(String.valueOf(mViewModel.getRandomNumbers()));

        return view;
    }

}