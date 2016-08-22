package com.leonel.crimeapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.leonel.crimeapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewEvent extends Fragment {

    EditText inputDate;

    public NewEvent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_new_event, container, false);
        inputDate = (EditText) view.findViewById(R.id.date);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String cDate = dateFormat.format(new Date());
        inputDate.setText(cDate);
    }

}
