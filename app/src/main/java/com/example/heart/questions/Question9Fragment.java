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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.example.heart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question9Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question9Fragment extends Fragment implements fragment_9 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity activity;

    public Question9Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question9Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question9Fragment newInstance(String param1, String param2) {
        Question9Fragment fragment = new Question9Fragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question9, container, false);

        final ToggleButton toggle11 = (ToggleButton) rootView.findViewById(R.id.toggle11);
        final ToggleButton toggle12 = (ToggleButton) rootView.findViewById(R.id.toggle12);
        final ToggleButton toggle13 = (ToggleButton) rootView.findViewById(R.id.toggle13);

        final ToggleButton toggle21 = (ToggleButton) rootView.findViewById(R.id.toggle21);
        final ToggleButton toggle22 = (ToggleButton) rootView.findViewById(R.id.toggle22);
        final ToggleButton toggle23 = (ToggleButton) rootView.findViewById(R.id.toggle23);

        final EditText editText1 = (EditText) rootView.findViewById(R.id.editTextText);
        editText1.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ((fragment_9) activity).FragmentBolez(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });

        toggle11.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle12.setChecked(false);
                    toggle13.setChecked(false);
                    try {
                        ((fragment_9) activity).FragmentSaxar("1");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle12.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle11.setChecked(false);
                    toggle13.setChecked(false);
                    try {
                        ((fragment_9) activity).FragmentSaxar("2");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle13.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle11.setChecked(false);
                    toggle12.setChecked(false);
                    try {
                        ((fragment_9) activity).FragmentSaxar("3");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });

        toggle21.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle22.setChecked(false);
                    toggle23.setChecked(false);
                    try {
                        ((fragment_9) activity).FragmentRodst("1");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle22.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle21.setChecked(false);
                    toggle23.setChecked(false);
                    try {
                        ((fragment_9) activity).FragmentRodst("2");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle23.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle21.setChecked(false);
                    toggle22.setChecked(false);
                    try {
                        ((fragment_9) activity).FragmentRodst("3");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }

    //===========
    public void FragmentSaxar (String saxar){}
    public void FragmentBolez (String bolez){}
    public void FragmentRodst (String rodst){}
    // Inflate the layout for this fragment
}