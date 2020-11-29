package com.example.heart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE2 = "";

    public String vozrast, pol, davlenie, xolesterin, sig;
    String sport, fizik, alko, alko2, ed_1, ed_2, ed_3;
    public Integer risk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle arguments = getIntent().getExtras();
        final TextView textView = findViewById(R.id.textView10);
        final TextView textViewColor = findViewById(R.id.textView14);

        final TextView zag1 = findViewById(R.id.zag1);
        final TextView text1 = findViewById(R.id.text1);
        final TextView zag2 = findViewById(R.id.zag2);
        final TextView text2 = findViewById(R.id.text2);
        final TextView zag3 = findViewById(R.id.zag3);
        final TextView text3 = findViewById(R.id.text3);
        final TextView zag4 = findViewById(R.id.zag4);
        final TextView text4 = findViewById(R.id.text4);
        final TextView zag5 = findViewById(R.id.zag5);
        final TextView text5 = findViewById(R.id.text5);

        zag1.setVisibility(View.GONE);
        zag2.setVisibility(View.GONE);
        zag3.setVisibility(View.GONE);
        zag4.setVisibility(View.GONE);
        zag5.setVisibility(View.GONE);

        text1.setVisibility(View.GONE);
        text2.setVisibility(View.GONE);
        text3.setVisibility(View.GONE);
        text4.setVisibility(View.GONE);
        text5.setVisibility(View.GONE);

        if(arguments!=null) {

            vozrast = arguments.get("vozrast").toString();
            pol = arguments.get("pol").toString();
            davlenie = arguments.get("davlenie").toString();
            xolesterin = arguments.get("xolesterin").toString();
            sig = arguments.get("sigert").toString();

            if (sig.equals("2") | sig.equals("3")){
                zag2.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
            }

            if(arguments.get("sport")!=null) {
                sport = arguments.get("sport").toString();
                fizik = arguments.get("fizik").toString();

                if (sport.equals("3") | fizik.equals("3")){
                    zag5.setVisibility(View.VISIBLE);
                    text5.setVisibility(View.VISIBLE);
                }
            }

            if(arguments.get("alko")!=null) {
                alko = arguments.get("alko").toString();
                alko2 = arguments.get("alko2").toString();

                if (alko.equals("1") | alko.equals("2") | alko2.equals("1") | alko2.equals("2")){
                    zag3.setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                }
            }

            if(arguments.get("ed_1")!=null) {
                ed_1 = arguments.get("ed_1").toString();
                ed_2 = arguments.get("ed_2").toString();
                ed_3 = arguments.get("ed_3").toString();

                if (ed_2.equals("3")){
                    zag4.setVisibility(View.VISIBLE);
                    text4.setVisibility(View.VISIBLE);
                }
                if (ed_3.equals("3")){
                    zag1.setVisibility(View.VISIBLE);
                    text1.setVisibility(View.VISIBLE);
                }
            }


            // отоюражаем нужные реокмендации



            textView.setText(sig);
//            test.setText(token);
            risk = diseaseRisk();
            textView.setText(risk.toString() + "%");
            if (risk >= 21){
                textView.setTextColor(Color.RED);
                textViewColor.setTextColor(Color.RED);
                textViewColor.setText("ВЫСОКИЙ");
            }
            if (risk >= 15 && risk < 21) {
                textView.setTextColor(Color.rgb(0xFF, 0xA2, 0x00));
                textViewColor.setTextColor(Color.rgb(0xFF, 0xA2, 0x00));
                textViewColor.setText("СРЕДНИЙ");
            }
            if (risk >= 9 && risk < 15) {
                textView.setTextColor(Color.YELLOW);
                textViewColor.setTextColor(Color.YELLOW);
                textViewColor.setText("СРЕДНИЙ");
            }
            if (risk < 9) {
                textView.setTextColor(Color.GREEN);
                textViewColor.setTextColor(Color.GREEN);
                textViewColor.setText("НИЗКИЙ");
            }
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