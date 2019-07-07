package com.example.gluttony.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gluttony.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment  {
    EditText et_Fname,et_Lname,et_Email,et_Username,et_Password,et_Address,et_Age;
    Button btn_reg;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_register, container, false);
        et_Fname = view.findViewById(R.id.etFirstname);
        et_Lname=view.findViewById(R.id.etLastname);
        et_Email=view.findViewById(R.id.etEmail);
        et_Username=view.findViewById(R.id.etUser);
        et_Password=view.findViewById(R.id.etPass);
        et_Address=view.findViewById(R.id.etAddress);
        et_Age=view.findViewById(R.id.etAge);
        btn_reg=view.findViewById(R.id.btnRegister);
        return view;
    }

}
