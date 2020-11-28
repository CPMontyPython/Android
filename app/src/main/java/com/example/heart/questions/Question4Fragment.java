package com.example.heart.questions;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.ToggleButton;

import com.example.heart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question4Fragment extends Fragment implements fragment_4 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity activity;

    public Question4Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question4Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question4Fragment newInstance(String param1, String param2) {
        Question4Fragment fragment = new Question4Fragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question4, container, false);

        final ToggleButton toggle11 = (ToggleButton) rootView.findViewById(R.id.toggle1);
        final ToggleButton toggle12 = (ToggleButton) rootView.findViewById(R.id.toggle2);
        final ToggleButton toggle13 = (ToggleButton) rootView.findViewById(R.id.toggle3);
        final RadioButton radioButton = (RadioButton) rootView.findViewById(R.id.radioButton);

        toggle11.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    toggle12.setChecked(false);
                    toggle13.setChecked(false);
                    try {
                        ((fragment_4) activity).FragmentSig("1");
                    }catch (ClassCastException ignored) {}
                }
            }
        });
        toggle12.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    toggle11.setChecked(false);
                    toggle13.setChecked(false);
                    try {
                        ((fragment_4) activity).FragmentSig("2");
                    }catch (ClassCastException ignored) {}
                }
            }
        });
        toggle13.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    toggle11.setChecked(false);
                    toggle12.setChecked(false);
                    try {
                        ((fragment_4) activity).FragmentSig("3");
                    }catch (ClassCastException ignored) {}
                }
            }
        });

        try {
            ((fragment_4) activity).FragmentPasiv("0");
        }catch (ClassCastException ignored) {}

        radioButton.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    try {
                        ((fragment_4) activity).FragmentPasiv("1");
                    }catch (ClassCastException ignored) {}
                }
                else {
                    try {
                        ((fragment_4) activity).FragmentPasiv("0");
                    }catch (ClassCastException ignored) {}
                }
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
    public void FragmentSig (String sig){}
    public void FragmentPasiv (String pasiv){}
}