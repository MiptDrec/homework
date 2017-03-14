package ru.mail.track.homework;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    final String LOG_TAG = "mY.lOg";
    int year_x,month_x, day_x;
    Calendar calendar = Calendar.getInstance();
    Date_picker dialog = new Date_picker();
    View v;
    TextView textv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment, null);
        final TextView textv = (TextView) v.findViewById(R.id.text1);
        final EditText name = (EditText) v.findViewById(R.id.name);
        final EditText surname = (EditText) v.findViewById(R.id.surname);

        final  Button btn = (Button) v.findViewById(R.id.btn);

        final String DIALOG_DATE = "date";
    //    btn.setEnabled(false);



        textv.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


          //      DialogFragment newFragment = new Date_picker();
        //        newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
                FragmentManager fm = getActivity().getFragmentManager();

                dialog.show(fm, DIALOG_DATE);
                if(dialog.year_x != 0)
                    textv.setText(dialog.year_x);



            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Activity2.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("surname", surname.getText().toString());
                getActivity().startActivity(intent);

            }
        });

        Log.d(LOG_TAG,"OnCreateView");

        return v;

    }



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void onAttach(Activity activity)  {
        super.onAttach(activity);
        Log.d(LOG_TAG,"OnAttach");

    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"OnResume");
    }



}
