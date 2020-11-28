package com.example.heart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE2 = "";

    public String vozrast, pol, davlenie, xolesterin, sig;
    public Integer risk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle arguments = getIntent().getExtras();
        final TextView textView = findViewById(R.id.textView10);
//        final TextView test = findViewById(R.id.textView7);

        if(arguments!=null) {
            vozrast = arguments.get("vozrast").toString();
            pol = arguments.get("pol").toString();
            davlenie = arguments.get("davlenie").toString();
            xolesterin = arguments.get("xolesterin").toString();
            sig = arguments.get("sigert").toString();
            textView.setText(sig);
//            test.setText(token);
            risk = diseaseRisk();
            textView.setText(risk.toString() + "%");
        }
    }

    // подсчет риска болезней
    public Integer diseaseRisk() {
        Integer riski = 0;
        Integer vozrasti = Integer.parseInt (vozrast);
        Integer davleniei = Integer.parseInt (davlenie);
        double xolesterini = Double.parseDouble(xolesterin);
        //мужчина
        if (pol.equals("man")){
            //1
            if (75 <= vozrasti){
                if (sig.equals("1")){
                    if (davleniei >= 160){
                        if (6.22 >= xolesterini) riski = 25;
                        if (6.22 <= xolesterini) riski = 30;
                    }
                    if (140 <= davleniei && davleniei <= 159){
                        if (6.22 >= xolesterini) riski = 20;
                        if (6.22 <= xolesterini) riski = 25;
                    }
                    if (130 <= davleniei && davleniei <= 139){
                        if (6.22 >= xolesterini) riski = 20;
                        if (6.22 <= xolesterini) riski = 25;
                    }
                    if (120 <= davleniei && davleniei <= 129){
                        if (6.22 >= xolesterini) riski = 16;
                        if (6.22 <= xolesterini) riski = 20;
                    }
                    if (davleniei <= 120){
                        if (6.22 >= xolesterini) riski = 12;
                        if (6.22 <= xolesterini) riski = 16;
                    }
                }
                else {
                    if (davleniei >= 160){
                        riski = 30;
                    }
                    if (140 <= davleniei && davleniei <= 159){
                        if (6.22 >= xolesterini) riski = 25;
                        if (6.22 <= xolesterini) riski = 30;
                    }
                    if (130 <= davleniei && davleniei <= 139){
                        if (6.22 >= xolesterini) riski = 25;
                        if (6.22 <= xolesterini) riski = 30;
                    }
                    if (120 <= davleniei && davleniei <= 129){
                        if (6.22 >= xolesterini) riski = 20;
                        if (6.22 <= xolesterini) riski = 25;
                    }
                    if (davleniei <= 120){
                        if (6.22 >= xolesterini) riski = 16;
                        if (6.22 <= xolesterini) riski = 20;
                    }
                }
            }
            //2
            if (70 <= vozrasti && vozrasti <= 74 ){
                if (sig.equals("1")){
                    if (davleniei >= 160){
                        if (6.22 >= xolesterini) riski = 20;
                        if (6.22 <= xolesterini) riski = 25;
                    }
                    if (140 <= davleniei && davleniei <= 159){
                        if (6.22 >= xolesterini) riski = 16;
                        if (6.22 <= xolesterini) riski = 20;
                    }
                    if (130 <= davleniei && davleniei <= 139){
                        if (6.22 >= xolesterini) riski = 16;
                        if (6.22 <= xolesterini) riski = 20;
                    }
                    if (120 <= davleniei && davleniei <= 129){
                        if (6.22 >= xolesterini) riski = 12;
                        if (6.22 <= xolesterini) riski = 16;
                    }
                    if (davleniei <= 120){
                        if (6.22 >= xolesterini) riski = 10;
                        if (6.22 <= xolesterini) riski = 12;
                    }
                }
                else {
                    if (davleniei >= 160){
                        if (6.22 >= xolesterini) riski = 25;
                        if (6.22 <= xolesterini) riski = 30;
                    }
                    if (140 <= davleniei && davleniei <= 159){
                        if (6.22 >= xolesterini) riski = 20;
                        if (6.22 <= xolesterini) riski = 25;
                    }
                    if (130 <= davleniei && davleniei <= 139){
                        if (6.22 >= xolesterini) riski = 20;
                        if (6.22 <= xolesterini) riski = 25;
                    }
                    if (120 <= davleniei && davleniei <= 129){
                        if (6.22 >= xolesterini) riski = 16;
                        if (6.22 <= xolesterini) riski = 20;
                    }
                    if (davleniei <= 120){
                        if (6.22 >= xolesterini) riski = 12;
                        if (6.22 <= xolesterini) riski = 16;
                    }
                }
            }
            //3
            if (65 <= vozrasti && vozrasti <= 69 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 16;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 20;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 10;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 20;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 25;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 25;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 30;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 16;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 20;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 16;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 20;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                }
            }
            //4
            if (60 <= vozrasti && vozrasti <= 64 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 10;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 10;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 16;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 20;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 10;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                }
            }
            //5
            if (55 <= vozrasti && vozrasti <= 59 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 10;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 10;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 10;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 16;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 25;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 30;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 30;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 20;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 25;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 30;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 12;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 20;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 25;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 30;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                }
            }
            //6
            if (50 <= vozrasti && vozrasti <= 54 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 10;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 10;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 10;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 10;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                }
            }
            //7
            if (45 <= vozrasti && vozrasti <= 49 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 10;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 10;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 16;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 25;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 30;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 12;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 20;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 10;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                }
            }
            //8
            if (40 <= vozrasti && vozrasti <= 44 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 10;
                        if (7.26 <= xolesterini) riski = 16;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                }
            }
            //9
            if (35 <= vozrasti && vozrasti <= 39 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                    //4-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                    //5-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 3;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 16;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 25;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 12;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 20;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 10;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 16;
                        if (7.26 <= xolesterini) riski = 25;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 12;
                        if (7.26 <= xolesterini) riski = 20;
                    }
                }
            }
            //10
            if ( vozrasti <= 34 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 12;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 10;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 10;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                }
            }
        }
        //женщина
        else {
            //1
            if (75 <= vozrasti){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 17;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 22;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 22;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 27;
                        if (7.26 <= xolesterini) riski = 27;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 14;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 17;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 17;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 11;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 14;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 13;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 11;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 22;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 27;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 27;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 30;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 17;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 22;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 22;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 27;
                        if (7.26 <= xolesterini) riski = 27;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 14;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 17;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 17;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 11;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 14;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 14;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                }
            }
            //2
            if (70 <= vozrasti && vozrasti <= 74 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 11;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 14;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 14;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 11;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 14;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 17;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 17;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 11;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 14;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 14;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 11;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                }
            }
            //3
            if (65 <= vozrasti && vozrasti <= 69 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 11;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 14;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 17;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 27;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 8;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 11;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 14;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                }
            }
            //4
            if (60 <= vozrasti && vozrasti <= 64 ){
                Log.i("uuuuuu", "1111111111");
                //не курящий
                if (sig.equals("1")){
                    Log.i("uuuuuu", "22222222");
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                }
            }
            //5
            if (55 <= vozrasti && vozrasti <= 59 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 3;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 6;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 11;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 17;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 5;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 14;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 27;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                }
            }
            //6
            if (50 <= vozrasti && vozrasti <= 54 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                }
            }
            //7
            if (45 <= vozrasti && vozrasti <= 49 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 4;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 8;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 17;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 27;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 3;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 6;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 14;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 5;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 27;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                }
            }
            //8
            if (40 <= vozrasti && vozrasti <= 44 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 3;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 0;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 2;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 3;
                        if (7.26 <= xolesterini) riski = 5;
                    }
                }
            }
            //9
            if (35 <= vozrasti && vozrasti <= 39 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 4;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 3;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 2;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 0;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 4;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 11;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 22;
                        if (7.26 <= xolesterini) riski = 30;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 3;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 8;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 17;
                        if (7.26 <= xolesterini) riski = 27;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 6;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 14;
                        if (7.26 <= xolesterini) riski = 22;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 1;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 2;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 5;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 11;
                        if (7.26 <= xolesterini) riski = 17;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                }
            }
            //10
            if ( vozrasti <= 34 ){
                //не курящий
                if (sig.equals("1")){
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 1;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 0;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 0;
                        if (7.26 <= xolesterini) riski = 1;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 0;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 0;
                        if (7.26 <= xolesterini) riski = 0;
                    }
                }
                //курящий
                else {
                    //1-строка
                    if (davleniei >= 160){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 4;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 8;
                        if (7.26 <= xolesterini) riski = 14;
                    }
                    //2-строка
                    if (140 <= davleniei && davleniei <= 159){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 3;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 6;
                        if (7.26 <= xolesterini) riski = 11;
                    }
                    //3-строка
                    if (130 <= davleniei && davleniei <= 139){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 5;
                        if (7.26 <= xolesterini) riski = 8;
                    }
                    //4-строка
                    if (120 <= davleniei && davleniei <= 129){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 1;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 2;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 4;
                        if (7.26 <= xolesterini) riski = 6;
                    }
                    //5-строка
                    if (davleniei <= 120){
                        if (4.14 >= xolesterini) riski = 0;
                        if (4.15 <= xolesterini && xolesterini <= 5.18) riski = 0;
                        if (5.19 <= xolesterini && xolesterini <= 6.22) riski = 1;
                        if (6.23 <= xolesterini && xolesterini <= 7.25) riski = 2;
                        if (7.26 <= xolesterini) riski = 3;
                    }
                }
            }
        }
        return riski;
    }
}