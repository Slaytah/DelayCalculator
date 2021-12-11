package com.example.DelayCalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView triplet = findViewById(R.id.minim_triplet);
        final TextView crotchet = findViewById(R.id.crotchet);
        final TextView crotchetTriplet = findViewById(R.id.crotchet_triplet);
        final TextView quaver = findViewById(R.id.quaver);
        final TextView quaverTriplet = findViewById(R.id.quaver_triplet);
        final TextView semiQuaver = findViewById(R.id.semiquaver);

        NumberPicker numberPicker = findViewById(R.id.number_picker);

        numberPicker.setMaxValue(200);
        numberPicker.setValue(120);

        setUpValues(numberPicker.getValue(),triplet, crotchet,crotchetTriplet,quaver,quaverTriplet,semiQuaver);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                setUpValues(newVal,triplet, crotchet,crotchetTriplet,quaver,quaverTriplet,semiQuaver);
            }
        });
    }


    void setUpValues(int pickerValue, TextView triplet, TextView crotchet, TextView crotchetTriplet,
                            TextView quaver, TextView quaverTriplet, TextView semiQuaver) {

        // e.g. 130 bpm = (130/60)
        float milliSecs = 1000 / ((float)pickerValue / 60);
        String outPut;

        outPut = String.format("%05.2f", (float)4/3 * milliSecs);
        triplet.setText(outPut);

        outPut = String.format("%05.2f", milliSecs);
        crotchet.setText(outPut);

        outPut = String.format("%05.2f", (float)4/6 * milliSecs);
        crotchetTriplet.setText(outPut);

        outPut = String.format("%05.2f", milliSecs / 2);
        quaver.setText(outPut);

        outPut = String.format("%05.2f", milliSecs / 3);
        quaverTriplet.setText(outPut);

        outPut = String.format("%05.2f", milliSecs / 4);
        semiQuaver.setText(outPut);;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
