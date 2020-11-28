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
 * Use the {@link Question7Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question7Fragment extends Fragment implements fragment_7 {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Activity activity;

    public Question7Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question7Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question7Fragment newInstance(String param1, String param2) {
        Question7Fragment fragment = new Question7Fragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question7, container, false);
        final ToggleButton toggle10 = (ToggleButton) rootView.findViewById(R.id.toggle10);
        final ToggleButton toggle20 = (ToggleButton) rootView.findViewById(R.id.toggle20);
        final ToggleButton toggle30 = (ToggleButton) rootView.findViewById(R.id.toggle30);

        final ToggleButton toggle11 = (ToggleButton) rootView.findViewById(R.id.toggle11);
        final ToggleButton toggle12 = (ToggleButton) rootView.findViewById(R.id.toggle12);
        final ToggleButton toggle13 = (ToggleButton) rootView.findViewById(R.id.toggle13);
        final ToggleButton toggle14 = (ToggleButton) rootView.findViewById(R.id.toggle14);

        final ToggleButton toggle21 = (ToggleButton) rootView.findViewById(R.id.toggle21);
        final ToggleButton toggle22 = (ToggleButton) rootView.findViewById(R.id.toggle22);
        final ToggleButton toggle23 = (ToggleButton) rootView.findViewById(R.id.toggle23);
        final ToggleButton toggle24 = (ToggleButton) rootView.findViewById(R.id.toggle24);

        final ToggleButton toggle31 = (ToggleButton) rootView.findViewById(R.id.toggle31);
        final ToggleButton toggle32 = (ToggleButton) rootView.findViewById(R.id.toggle32);
        final ToggleButton toggle33 = (ToggleButton) rootView.findViewById(R.id.toggle33);
        final ToggleButton toggle34 = (ToggleButton) rootView.findViewById(R.id.toggle34);

        toggle11.setVisibility(View.INVISIBLE);
        toggle12.setVisibility(View.INVISIBLE);
        toggle13.setVisibility(View.INVISIBLE);
        toggle14.setVisibility(View.INVISIBLE);

        toggle11.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle12.setChecked(false);
                    toggle13.setChecked(false);
                    toggle14.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentSon("1");
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
                    toggle14.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentSon("2");
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
                    toggle14.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentSon("3");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle14.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle11.setChecked(false);
                    toggle13.setChecked(false);
                    toggle12.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentSon("4");
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
                    toggle34.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentStres("1");
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
                    toggle34.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentStres("2");
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
                    toggle34.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentStres("3");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });
        toggle34.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle31.setChecked(false);
                    toggle33.setChecked(false);
                    toggle32.setChecked(false);
                    try {
                        ((fragment_7) activity).FragmentStres("4");
                    } catch (ClassCastException ignored) {
                    }
                }
            }
        });

        toggle10.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle11.setVisibility(View.VISIBLE);
                    toggle12.setVisibility(View.VISIBLE);
                    toggle13.setVisibility(View.VISIBLE);
                    toggle14.setVisibility(View.VISIBLE);
                } else {
                    toggle11.setVisibility(View.INVISIBLE);
                    toggle12.setVisibility(View.INVISIBLE);
                    toggle13.setVisibility(View.INVISIBLE);
                    toggle14.setVisibility(View.INVISIBLE);
                }
            }
        });
        toggle20.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle21.setVisibility(View.VISIBLE);
                    toggle22.setVisibility(View.VISIBLE);
                    toggle23.setVisibility(View.VISIBLE);
                    toggle24.setVisibility(View.VISIBLE);
                } else {
                    toggle21.setVisibility(View.INVISIBLE);
                    toggle22.setVisibility(View.INVISIBLE);
                    toggle23.setVisibility(View.INVISIBLE);
                    toggle24.setVisibility(View.INVISIBLE);
                }
            }
        });
        toggle30.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle31.setVisibility(View.VISIBLE);
                    toggle32.setVisibility(View.VISIBLE);
                    toggle33.setVisibility(View.VISIBLE);
                    toggle34.setVisibility(View.VISIBLE);
                } else {
                    toggle31.setVisibility(View.INVISIBLE);
                    toggle32.setVisibility(View.INVISIBLE);
                    toggle33.setVisibility(View.INVISIBLE);
                    toggle34.setVisibility(View.INVISIBLE);
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
    public void FragmentSon (String son){}
    public void FragmentStres (String stres){}
    // Inflate the layout for this fragment
}
