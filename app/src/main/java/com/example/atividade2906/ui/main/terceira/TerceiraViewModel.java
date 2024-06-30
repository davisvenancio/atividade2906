package com.example.atividade2906.ui.main.terceira;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TerceiraViewModel extends ViewModel {
    private ArrayList<Integer> randomNumbers = new ArrayList<>();

    public void setNumbers(ArrayList<Integer> numbers) {
        randomNumbers.clear();
        randomNumbers.addAll(numbers);
        Log.d("TerceiraViewModel", "setNumbers: " + randomNumbers);
    }

    public ArrayList<Integer> getRandomNumbers() {
        Log.d("TerceiraViewModel", "getRandomNumbers: " + randomNumbers);
        return randomNumbers;
    }
}