package ru.mail.track.homework;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



  //  TextView textView = (TextView) findViewById(R.id.text1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String year = intent.getStringExtra("year");
        String month = intent.getStringExtra("month");
        TextView txt = (TextView) findViewById(R.id.text1);
        if (year != null)
            txt.setText(month);

    }

 //////   public void onCLick(View v) {
 //       if(v.getId() == R.id.text1)
 //        dlg.show(getFragmentManager(), "dlg");
 //   }
}
