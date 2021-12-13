package com.example.series2_contextmenuex092;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_credit extends AppCompatActivity {
    TextView ctext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        ctext = (TextView) findViewById(R.id.ctext);
        ctext.setText("Credits:\n\n\n"+ "Created by Agam T");
    }

    /**
     * Button:
     * Short description - Go To Activity_Main.
     *
     * <p>
     *
     * @param view
     */
    public void goBack(View view) {
        finish();
    }
}