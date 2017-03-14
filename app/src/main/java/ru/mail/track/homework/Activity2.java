package ru.mail.track.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fotol on 13.03.17.
 */

public class Activity2 extends AppCompatActivity {


    TextView name;
    TextView surname;
    Button edit_btn;

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        name = (TextView) findViewById(R.id.name_2);
        surname= (TextView) findViewById(R.id.surname_2);
        edit_btn = (Button) findViewById(R.id.edit_btn);

        Intent intent = getIntent();

        String name_s = intent.getStringExtra("name");
        String surname_s = intent.getStringExtra("surname");



        name.setText(name_s);
        surname.setText(surname_s);

        final Intent intent_to_fst = new Intent(this, MainActivity.class);


        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent_to_fst);
            }
        });

    }
}
