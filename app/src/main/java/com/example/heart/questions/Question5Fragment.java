package com.example.heart.questions;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.heart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question5Fragment extends Fragment implements fragment_5 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity activity;

    public Question5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question5Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question5Fragment newInstance(String param1, String param2) {
        Question5Fragment fragment = new Question5Fragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question5, container, false);

        final ToggleButton toggle11 = (ToggleButton) rootView.findViewById(R.id.toggle11);
        final ToggleButton toggle12 = (ToggleButton) rootView.findViewById(R.id.toggle12);
        final ToggleButton toggle13 = (ToggleButton) rootView.findViewById(R.id.toggle13);

        final ToggleButton toggle21 = (ToggleButton) rootView.findViewById(R.id.toggle21);
        final ToggleButton toggle22 = (ToggleButton) rootView.findViewById(R.id.toggle22);

        toggle11.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle12.setChecked(false);
                    toggle13.setChecked(false);
                    try {
                        ((fragment_5) activity).FragmentSport("1");
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
                        ((fragment_5) activity).FragmentSport("2");
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
                        ((fragment_5) activity).FragmentSport("3");
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
                    try {
                        ((fragment_5) activity).FragmentFizik("1");
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
                    try {
                        ((fragment_5) activity).FragmentFizik("2");
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
    public void FragmentSport (String sport){}
    public void FragmentFizik(String fizik){}
    // Inflate the layout for this fragment
}
