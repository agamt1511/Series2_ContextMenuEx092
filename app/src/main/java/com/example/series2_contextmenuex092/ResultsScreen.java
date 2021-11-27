package com.example.series2_contextmenuex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Agam Toledano
 * @version 1.0
 * @since 27/11/2021
 * Short description - Practice (Context Menu) - Calculator for arithmetic series & engineering series.
 */

public class ResultsScreen extends AppCompatActivity {
    ListView items;
    TextView chosen;
    Intent toFirst;
    double fOrgan, srm;
    double[] numbers = new double[20];
    double[] sum = new double[20];
    boolean oSeries;
    int pos = 0;
    String[] organs = new String[20];
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        items = (ListView) findViewById(R.id.items);
        chosen = (TextView) findViewById(R.id.chosen);
        toFirst = getIntent();

        /**
         * Short description - Receives data, and calculates the members of the series and their amount according to the series.
         */
        fOrgan = toFirst.getDoubleExtra("fOrgan", -1000000000);
        srm = toFirst.getDoubleExtra("srm", -1000000000);
        oSeries = toFirst.getBooleanExtra("oSeries", true);

        numbers[0] = fOrgan;
        organs[0] = String.valueOf(numbers[0]);
        sum[0] = numbers[0];
        if (oSeries == false) {
            for (int i = 1; i < 20; i++) {
                numbers[i] = numbers[i - 1] + srm;
                organs[i] = String.valueOf(numbers[i]);
                sum[i] = sum[i - 1] + numbers[i];
            }
        } else {
            for (int i = 1; i < 20; i++) {
                numbers[i] = numbers[i - 1] * srm;
                organs[i] = String.valueOf(numbers[i]);
                sum[i] = sum[i - 1] + numbers[i];
            }
        }


        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,organs);
        items.setAdapter(adp);
        items.setOnCreateContextMenuListener(this);

        /**
         * Button - LongClick:
         * Short description - Maintains the position of the pressed organ.
         * <p>
         *
         * @param AdapterView
         * @return false
         */
        items.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                return false;
            }
        });
    }

    /**
     * ContextMenu:
     * Short description - Creation of ContextMenu.
     * <p>
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Location");
        menu.add("Sum");
    }

    /**
     * ContextMenu:
     * Short description - Activating the ContextMenu.
     * <p>
     *
     * @param item
     * @return super.onContextItemSelected(item);
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("Sum")) {
            chosen.setText("Sum: " + sum[pos]);

        }
        else{
            place = (String.valueOf(pos+1));
            chosen.setText("Location: " + place);
        }

        return super.onContextItemSelected(item);
    }

    /**
     * Button:
     *Short description - Ends the current activity
     * <p>
     *
     * @param view
     * @return none
     */
    public void goBack(View view) {
        finish();
    }
}