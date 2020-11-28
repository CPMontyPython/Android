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
 * Use the {@link Question8Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question8Fragment extends Fragment implements fragment_8 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity activity;

    public Question8Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question8Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question8Fragment newInstance(String param1, String param2) {
        Question8Fragment fragment = new Question8Fragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question8, container, false);

        final ToggleButton toggle11 = (ToggleButton) rootView.findViewById(R.id.toggle11);
        final ToggleButton toggle12 = (ToggleButton) rootView.findViewById(R.id.toggle12);
        final ToggleButton toggle13 = (ToggleButton) rootView.findViewById(R.id.toggle13);

        final ToggleButton toggle21 = (ToggleButton) rootView.findViewById(R.id.toggle21);
        final ToggleButton toggle22 = (ToggleButton) rootView.findViewById(R.id.toggle22);
        final ToggleButton toggle23 = (ToggleButton) rootView.findViewById(R.id.toggle23);

        final ToggleButton toggle31 = (ToggleButton) rootView.findViewById(R.id.toggle31);
        final ToggleButton toggle32 = (ToggleButton) rootView.findViewById(R.id.toggle32);
        final ToggleButton toggle33 = (ToggleButton) rootView.findViewById(R.id.toggle33);

        final ToggleButton toggle41 = (ToggleButton) rootView.findViewById(R.id.toggle41);
        final ToggleButton toggle42 = (ToggleButton) rootView.findViewById(R.id.toggle42);
        final ToggleButton toggle43 = (ToggleButton) rootView.findViewById(R.id.toggle43);

        toggle11.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle12.setChecked(false);
                    toggle13.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd1("1");
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
                        ((fragment_8) activity).FragmentEd1("2");
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
                        ((fragment_8) activity).FragmentEd1("3");
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
                        ((fragment_8) activity).FragmentEd2("1");
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
                        ((fragment_8) activity).FragmentEd2("2");
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
                        ((fragment_8) activity).FragmentEd2("3");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });

        toggle31.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle32.setChecked(false);
                    toggle33.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd31("1");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle32.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle31.setChecked(false);
                    toggle33.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd31("2");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle33.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle31.setChecked(false);
                    toggle32.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd31("3");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });

        toggle41.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle42.setChecked(false);
                    toggle43.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd32("1");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle42.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle41.setChecked(false);
                    toggle43.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd32("2");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle43.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle41.setChecked(false);
                    toggle42.setChecked(false);
                    try {
                        ((fragment_8) activity).FragmentEd32("3");
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
    public void FragmentEd1 (String ed_1){}
    public void FragmentEd2(String ed_2){}
    public void FragmentEd31(String ed_31){}
    public void FragmentEd32 (String ed_32){}
    // Inflate the layout for this fragment
}
