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
import android.widget.EditText;

import com.example.heart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FIOFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FIOFragment extends Fragment implements lid_dan {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Activity activity;


    public FIOFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FIOFragment newInstance(String param1, String param2) {
        FIOFragment fragment = new FIOFragment();
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

        final View rootView = inflater.inflate(R.layout.fragment_question, container, false);


        //Передаем данные в Активити(Фамилия)
        final EditText editText1 = (EditText) rootView.findViewById(R.id.editTextSurname);
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
                    ((lid_dan) activity).FragmentSurname(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });
        //==========

        //Передаем данные в Активити(Имя)
        final EditText editText2 = (EditText) rootView.findViewById(R.id.editTextName);
        editText2.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ((lid_dan) activity).FragmentName(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });
        //==========

        //Передаем данные в Активити(Отчество)
        final EditText editText3 = (EditText) rootView.findViewById(R.id.editTextPatronymic);
        editText3.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    ((lid_dan) activity).FragmentPatronymic(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });
        //==========

        //Передаем данные в Активити(Телефон)
        final EditText editText4 = (EditText) rootView.findViewById(R.id.editTextPhone);
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
                    ((lid_dan) activity).FragmentPhone(s.toString());
                }catch (ClassCastException ignored) {}
            }
        });
        //==========

        return rootView;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }
//, String name, String patronymic, String phone
    public void FragmentSurname (String surname){}
    public void FragmentName (String name){}
    public void FragmentPatronymic (String patronymic){}
    public void FragmentPhone (String phone){}

}


