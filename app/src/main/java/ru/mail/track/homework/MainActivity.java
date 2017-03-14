package ru.mail.track.homework;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    TextView date;
    String date_s;
    String date_saved;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String name_s = intent.getStringExtra("name");
        String surname_s = intent.getStringExtra("surname");
        String date_s = intent.getStringExtra("date");
        if(name_s != null && surname_s != null && date_s != null) {

            TextView name = (TextView) findViewById(R.id.name);
            TextView surname = (TextView) findViewById(R.id.surname);
            TextView date = (TextView) findViewById(R.id.text1);

            name.setText(name_s);
            surname.setText(surname_s);
            date.setText(date_s);

        }

    }



    public void onSaveInstanceState(Bundle savedInstanceState) {

        date = (TextView) findViewById(R.id.text1);
        savedInstanceState.putString("Date_saved", date.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
      TextView date = (TextView) findViewById(R.id.text1);
       date_saved = savedInstanceState.getString("Date_saved");

           date.setText(date_saved);


    }

}
