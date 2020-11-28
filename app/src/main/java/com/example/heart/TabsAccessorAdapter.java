package com.example.heart;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.heart.questions.FIOFragment;
import com.example.heart.questions.LastQuestion;
import com.example.heart.questions.Question1Fragment;
import com.example.heart.questions.Question3Fragment;
import com.example.heart.questions.Question4Fragment;
import com.example.heart.questions.Question5Fragment;
import com.example.heart.questions.Question6Fragment;
import com.example.heart.questions.Question7Fragment;
import com.example.heart.questions.Question8Fragment;
import com.example.heart.questions.Question9Fragment;

public class TabsAccessorAdapter extends FragmentPagerAdapter {

    public TabsAccessorAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(final int i) {
        switch (i){
            case 0:
                FIOFragment fioFragment = new FIOFragment();
                return fioFragment;
            case 1:
                Question1Fragment question1Fragment = new Question1Fragment();
                return question1Fragment;
            case 2:
                Question3Fragment question3Fragment = new Question3Fragment();
                return question3Fragment;
            case 3:
                Question4Fragment question4Fragment = new Question4Fragment();
                return question4Fragment;
            case 4:
                Question5Fragment question5Fragment = new Question5Fragment();
                return question5Fragment;
            case 5:
                Question6Fragment question6Fragment = new Question6Fragment();
                return question6Fragment;
            case 6:
                Question7Fragment question7Fragment = new Question7Fragment();
                return question7Fragment;
            case 7:
                Question8Fragment question8Fragment = new Question8Fragment();
                return question8Fragment;
            case 8:
                Question9Fragment question9Fragment = new Question9Fragment();
                return question9Fragment;
            case 9:
                LastQuestion lastQuestion = new LastQuestion();
                return lastQuestion;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Фио";
            case 1:
                return "Вопрос 1";
            case 2:
                return "Вопрос 2";
            case 3:
                return "Вопрос 3";
            case 4:
                return "Вопрос 4";
            case 5:
                return "Вопрос 5";
            case 6:
                return "Вопрос 6";
            case 7:
                return "Вопрос 7";
            case 8:
                return "Вопрос 8";
            case 9:
                return "Вопрос 9";

            default:
                return null;
        }
    }
}


