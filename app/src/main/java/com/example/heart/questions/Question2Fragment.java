package com.example.heart.questions;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.heart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question2Fragment extends Fragment implements fragment_2 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Activity activity;

    public Question2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question2Fragment newInstance(String param1, String param2) {
        Question2Fragment fragment = new Question2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_question2, container, false);
        final TextView rost = (TextView) rootView.findViewById(R.id.fr_2_rost);
        final SeekBar seekBar1 = (SeekBar) rootView.findViewById(R.id.fr_2_sekbar1);
        final TextView ves = (TextView) rootView.findViewById(R.id.fr_2_ves);
        final SeekBar seekBar2 = (SeekBar) rootView.findViewById(R.id.fr_2_sekbar2);
        final TextView taliy = (TextView) rootView.findViewById(R.id.fr_2_taliy);
        final SeekBar seekBar3 = (SeekBar) rootView.findViewById(R.id.fr_2_sekbar3);

        try {
            ((fragment_2) activity).FragmentFRost("150");
            ((fragment_2) activity).FragmentVes("70");
            ((fragment_2) activity).FragmentTaliy("85");
        }catch (ClassCastException ignored) {}

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rost.setText(String.valueOf(seekBar.getProgress()+120));
                try {
                    ((fragment_2) activity).FragmentFRost(String.valueOf(seekBar.getProgress()+120));
                }catch (ClassCastException ignored) {}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ves.setText(String.valueOf(seekBar.getProgress()+40));
                try {
                    ((fragment_2) activity).FragmentVes(String.valueOf(seekBar.getProgress()+40));
                }catch (ClassCastException ignored) {}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                taliy.setText(String.valueOf(seekBar.getProgress()+55));
                try {
                    ((fragment_2) activity).FragmentTaliy(String.valueOf(seekBar.getProgress()+55));
                }catch (ClassCastException ignored) {}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }

    //===========
    public void FragmentFRost (String rost){}
    public void FragmentVes (String ves){}
    public void FragmentTaliy (String taliy){}
}