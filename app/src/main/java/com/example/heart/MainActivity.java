package com.example.heart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heart.questions.fragment_1;
import com.example.heart.questions.fragment_2;
import com.example.heart.questions.fragment_3;
import com.example.heart.questions.fragment_4;
import com.example.heart.questions.fragment_5;
import com.example.heart.questions.fragment_6;
import com.example.heart.questions.fragment_7;
import com.example.heart.questions.fragment_8;
import com.example.heart.questions.fragment_9;
import com.example.heart.questions.lid_dan;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements lid_dan, fragment_1, fragment_3, fragment_4, fragment_5, fragment_6, fragment_7, fragment_8, fragment_9 {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabsAccessorAdapter tabsAccessorAdapter;

    String surnameF, nameF, patronymicF, phoneF;

    String ageF, floorF;

    String rostF, vesF;

    String davl1F, davl2F, cerdF, xalestF;

    String sportF, fizikF;

    String alkoF, alko2F;

    String sigF, pasivF;

    String sonF, stresF;

    String ed_1F, ed_2F, ed_31F, ed_32F;

    String saxarF, bolezF, rodstF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Heart");

        viewPager = (ViewPager) findViewById(R.id.main_tabs_pager);
        tabsAccessorAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAccessorAdapter);

        tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);


        TabsAccessorAdapter adapter = new TabsAccessorAdapter(getSupportFragmentManager());

        final ViewPager viewPager = findViewById(R.id.main_tabs_pager);
        viewPager.setAdapter(adapter); // устанавливаем адаптер

        final Button further = findViewById(R.id.further);

        further.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Integer h = viewPager.getCurrentItem();

                if (h == 9) {
                    String json_risk = "{\r\n    \"Vozrast\": \"" + ageF + "\",\r\n    \"Pol\": \"" + floorF +
                            "\",\r\n    \"Sigareta\": \"" + sigF + "\",\r\n    \"Davlenie\": \"" + davl1F + "\",\r\n    \"Xolesterin\": \"" + xalestF + "\"\r\n}";


                    Log.i("uuuuuu", json_risk);

                    sendMessage();
                }
                else{
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1); // выводим следуюющий экран
                }
            }
        });

    }

    // Переход на новую активность
    public void sendMessage() {
        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra("vozrast", ageF);
        intent.putExtra("pol", floorF);
        intent.putExtra("sigert", sigF);
        intent.putExtra("davlenie", davl1F);
        intent.putExtra("xolesterin", xalestF);

        intent.putExtra("sport", sportF);
        intent.putExtra("fizik", fizikF);

        intent.putExtra("alko", alkoF);
        intent.putExtra("alko2", alko2F);

        intent.putExtra("ed_1", ed_1F);
        intent.putExtra("ed_2", ed_2F);

        intent.putExtra("ed_3", ed_31F);

//        intent.putExtra("price", price);
        startActivity(intent);
    }


    @Override
    public void FragmentSurname (String surname) {
        surnameF = surname;
    }
    @Override
    public void FragmentName (String name) {
        nameF = name;
    }
    @Override
    public void FragmentPatronymic (String patronymic) {
        patronymicF = patronymic;
    }
    @Override
    public void FragmentPhone (String phone) {
        phoneF = phone;
    }

    //fragment_1
    @Override
    public void FragmentAge (String age) {
        ageF = age;
    }
    @Override
    public void FragmentFloor (String floor) {
        floorF = floor;
    }
    @Override
    public void FragmentFRost (String rost) {
        rostF = rost;
    }
    @Override
    public void FragmentVes (String ves) {
        vesF = ves;
    }

    //fragment_3
    @Override
    public void FragmentFDavl1 (String davl1) {
        davl1F = davl1;
    }
    @Override
    public void FragmentFDavl2 (String davl2) {
        davl2F = davl2;
    }
    @Override
    public void FragmentCerd (String cerd) {
        cerdF = cerd;
    }
    @Override
    public void FragmentXalest (String xalest) {
        xalestF = xalest;
    }

    //fragment_4
    @Override
    public void FragmentSig (String sig) {
        sigF = sig;
    }
    @Override
    public void FragmentPasiv (String pasiv) {
        pasivF = pasiv;
    }

    //fragment_5
    @Override
    public void FragmentSport (String sport) {
        sportF = sport;
    }
    @Override
    public void FragmentFizik (String fizik) {
        fizikF = fizik;
    }


    //fragment_6
    @Override
    public void FragmentAlko (String alko) {
        alkoF = alko;
    }
    @Override
    public void FragmentAlko2 (String alko2) {
        alko2F = alko2;
    }

    //fragment_7
    @Override
    public void FragmentSon (String son) {
        sonF = son;
    }
    @Override
    public void FragmentStres (String stres) {
        stresF = stres;
    }

    //fragment_8
    @Override
    public void FragmentEd1 (String ed_1) {
        ed_1F = ed_1;
    }
    @Override
    public void FragmentEd2 (String ed_2) {
        ed_2F = ed_2;
    }
    @Override
    public void FragmentEd31 (String ed_31) {
        ed_31F = ed_31;
    }
    @Override
    public void FragmentEd32 (String ed_32) {
        ed_32F = ed_32;
    }

    //fragment_9
    @Override
    public void FragmentSaxar (String saxar) {
        saxarF = saxar;
    }
    @Override
    public void FragmentBolez (String bolez) {
        bolezF = bolez;
    }
    @Override
    public void FragmentRodst (String rodst) {
        rodstF = rodst;
    }

    public void setCurrentItem (int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }

}