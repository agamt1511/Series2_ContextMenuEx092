package com.example.series2_contextmenuex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * @author Agam Toledano
 * @version 1.0
 * @since 27/11/2021
 * Short description - Practice (Context Menu) - Calculator for arithmetic series & engineering series.
 */

public class MainActivity extends AppCompatActivity {
    Switch sType;
    EditText organF, remMul;
    Button result;
    Intent toResult;
    String textOF, textRM;
    double fOrgan, srm;
    boolean oSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sType = (Switch) findViewById(R.id.sType);
        organF = (EditText) findViewById(R.id.organF);
        remMul = (EditText) findViewById(R.id.remMul);
        result = (Button) findViewById(R.id.result);
        toResult = new Intent(this,ResultsScreen.class);

    }

    /**
     * tryNum:
     * Short description - Checks if the input is a number.
     * @param textOF
     * @param textRM
     * @return false if try failed, else true
     */
    public static boolean tryNum(String textOF,String textRM){
        int checkAns;
        try {
            double fOrgan = Double.valueOf(textOF);
            double srm = Double.valueOf(textRM);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * Button:
     * Short description - Receives input and sends it to Activity_Results.
     * <p>
     *
     * @param view
     * @return none
     */
    public void goResults(View view) {
        textOF = organF.getText().toString();
        textRM = remMul.getText().toString();

        if(tryNum(textOF,textRM)==false){
            Toast.makeText(this,"Error!Wrong input!",Toast.LENGTH_LONG).show();
        }
        else{
            fOrgan = Double.valueOf(textOF);
            srm = Double.valueOf(textRM);
            oSeries = sType.isChecked();
            toResult.putExtra("fOrgan", fOrgan);
            toResult.putExtra("srm", srm);
            toResult.putExtra("oSeries", oSeries);
            startActivity(toResult);
        }
    }
}