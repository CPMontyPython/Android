package com.example.heart.questions;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.heart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question1Fragment extends Fragment implements fragment_1 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView text;
    private EditText edit;
    private Button bGet;
    Activity activity;

    public Question1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question1Fragment newInstance(String param1, String param2) {
        Question1Fragment fragment = new Question1Fragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question1, container, false);
        final EditText editText4 = (EditText) rootView.findViewById(R.id.fr_xol);
        final EditText editText5 = (EditText) rootView.findViewById(R.id.fr_1_age2);
        final EditText editText6 = (EditText) rootView.findViewById(R.id.fr_1_age3);
        final ToggleButton button_men = (ToggleButton) rootView.findViewById(R.id.fr_1_men);
        final ToggleButton button_woman = (ToggleButton) rootView.findViewById(R.id.fr_1_woman);

        try {
            ((fragment_1) activity).FragmentFloor("man");
        }catch (ClassCastException ignored) {}

        try {
            ((fragment_1) activity).FragmentAge("60");
        }catch (ClassCastException ignored) {}

        button_men.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    button_woman.setChecked(false);
                    try {
                        ((fragment_1) activity).FragmentFloor("man");
                    }catch (ClassCastException ignored) {}
                }
            }
        });
        button_woman.setOnCheckedChangeListener( new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    button_men.setChecked(false);
                    try {
                        ((fragment_1) activity).FragmentFloor("woman");
                    }catch (ClassCastException ignored) {}
                }
            }
        });

        editText4.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ((fragment_1) activity).FragmentAge(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });

        editText5.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ((fragment_1) activity).FragmentFRost(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });

        editText6.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ((fragment_1) activity).FragmentVes(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }

    //===========
    public void FragmentFloor (String floor){}
    public void FragmentAge (String age){}
    public void FragmentFRost (String rost){}
    public void FragmentVes (String ves){}

}
