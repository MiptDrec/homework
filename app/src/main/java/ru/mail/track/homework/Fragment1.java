package ru.mail.track.homework;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by fotol on 13.03.17.
 */

public class Fragment1 extends Fragment {


    Calendar calendar = Calendar.getInstance();
    Date_picker dialog = new Date_picker();
    View v;
    TextView textv;
    boolean bool = false;
    boolean bool1 = false;
    boolean bool2 = false;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment, null);
        final TextView textv = (TextView) v.findViewById(R.id.text1);
        final EditText name = (EditText) v.findViewById(R.id.name);
        final EditText surname = (EditText) v.findViewById(R.id.surname);



        final  Button btn = (Button) v.findViewById(R.id.btn);

        final String DIALOG_DATE = "date";
        btn.setEnabled(false);



        textv.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                FragmentManager fm = getActivity().getFragmentManager();

                dialog.show(fm, DIALOG_DATE);

            }
        });




        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if(name.getText().toString() == "Name" && bool == false)
                name.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(name.getText().length() != 0)
                    bool = true;
                else
                    bool = false;
                if(bool && bool1  && bool2 == true)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
        });

        surname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(surname.getText().length() != 0)
                    bool1 = true;
                else
                    bool1 = false;

                if(bool && bool1 && bool2 == true)
                   btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(), Activity2.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("surname", surname.getText().toString());
                intent.putExtra("date", textv.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               getActivity().startActivity(intent);
                getActivity().finish();

            }
        });

        textv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(textv.getText().toString() != "Data")
                    bool2 = true;

                if(bool && bool1 && bool2 == true)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return v;

    }





    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
