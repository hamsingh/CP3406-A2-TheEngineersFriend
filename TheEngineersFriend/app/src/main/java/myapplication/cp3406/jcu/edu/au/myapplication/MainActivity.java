package myapplication.cp3406.jcu.edu.au.myapplication;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static java.lang.Boolean.FALSE;
import static myapplication.cp3406.jcu.edu.au.myapplication.SettingsActivity.SETTINGS_REQUEST;

public class MainActivity extends AppCompatActivity {
    public Boolean powerResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            powerResult = savedInstanceState.getBoolean("powerResult");
        }
    }

    // Save state of powerResult onj pause or stop
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("powerResult", powerResult);
    }

    // Check for a requests from settings page and store it in powerResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SETTINGS_REQUEST){
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    powerResult = data.getBooleanExtra("result", FALSE);
                    System.out.println(powerResult);
                }
            }
        }
    }

    // Open Settings
    public void openSettings(View v){
        Intent intent = new Intent(this, myapplication.cp3406.jcu.edu.au.myapplication.SettingsActivity.class);
        intent.putExtra("powerResult", powerResult);
        System.out.println(powerResult);
        startActivityForResult(intent, SettingsActivity.SETTINGS_REQUEST);
    }

    // Open Ohms Law Calculator
    public void openConverter(View v){
        Intent intent = new Intent(this, myapplication.cp3406.jcu.edu.au.myapplication.Converter.class);
        intent.putExtra("powerResult", powerResult);
        startActivity(intent);
    }

    //Open Resistor Value Finder
    public void openFindResistor(View v){
        Intent intent = new Intent(this, myapplication.cp3406.jcu.edu.au.myapplication.ResistorFinder.class);
        startActivity(intent);
    }
}
