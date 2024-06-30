package com.example.atividade2906.ui.main.segunda;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.atividade2906.TerceiraActivity;
import com.example.atividade2906.service.SoundService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SegundaViewModel extends ViewModel {
    private int number;
    private ArrayList<Integer> randomNumbers;
    private Handler handler = new Handler(Looper.getMainLooper());
    private NumberUpdateListener listener;
    private Context context;
    private Intent serviceIntent;

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        generateRandomNumber(number);
    }

    public ArrayList<Integer> getRandomNumbers() {
        Log.d("SegundaViewModel", "getRandomNumbers: " + randomNumbers);
        return randomNumbers;
    }

    private void generateRandomNumber(int number) {
        randomNumbers = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < number; i++){
            randomNumbers.add(random.nextInt(100));
        }
    }


    public void setListener(NumberUpdateListener listener){
        this.listener = listener;
    }

    public void startDisplayingNumbers(){

        serviceIntent = new Intent(context, SoundService.class);
        context.startService(serviceIntent);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < randomNumbers.size(); i++) {
                    int number = randomNumbers.get(i);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(listener != null){
                                listener.onNumberUpdate(number);
                            }
                        }
                    });

                    try {
                        Thread.sleep(2229);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if(context != null)
                    context.stopService(serviceIntent);



            }
        }).start();
    }




    public interface NumberUpdateListener {
        void onNumberUpdate(int number);
    }

}