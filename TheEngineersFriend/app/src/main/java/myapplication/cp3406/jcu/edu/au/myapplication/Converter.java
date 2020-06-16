package myapplication.cp3406.jcu.edu.au.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Converter extends AppCompatActivity {
    private Spinner spinner;
    private EditText voltage;
    private EditText current;
    private EditText resistance;
    private EditText power;
    private TextView powerUnit;
    private TextView powerName;
    public Boolean powerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        // Set IDs and link to XML
        spinner = findViewById(R.id.spinner);
        voltage = findViewById(R.id.voltage);
        current = findViewById(R.id.current);
        resistance = findViewById(R.id.resistance);
        power = findViewById(R.id.power);
        powerUnit = findViewById(R.id.powerUnit);
        powerName = findViewById(R.id.powerName);

        // get intent extra
        powerResult = getIntent().getBooleanExtra("powerResult", false);

        // check the users settings choice
        checkPowerResult();
    }


    // Calculate the result based on user inputs, run when calculate button is pressed
    public void CalculateResult(View view) {
        String item = spinner.getSelectedItem().toString();
        // Run zero check for user input values
        zeronullCheck();

        // convert to get text and convert string
        String v = voltage.getText().toString();
        String c = current.getText().toString();
        String r = resistance.getText().toString();

        // convert user inputs to floats
        float V = Float.parseFloat(v);
        float C = Float.parseFloat(c);
        float R = Float.parseFloat(r);

        // run calculations based off user inputs
        String[] results = ConverterCalculations.organiseVariables(item, V, C, R);
        String variable = results[0];

        // check which variable was calculated
        if (variable == "voltage") {
            String voltageS = results[1];
            voltage.setText(voltageS);
            V = Float.valueOf(voltageS);
            float P = ConverterCalculations.calculatePower(V, C);
            power.setText(Float.toString(P));
        }   else if (variable == "current") {
            String currentS = results[1];
            current.setText(currentS);
            V = Float.valueOf(currentS);
            float P = ConverterCalculations.calculatePower(V, C);
            power.setText(Float.toString(P));
        }   else if (variable == "resistance")  {
            String resistanceS = results[1];
            voltage.setText(resistanceS);
            V = Float.valueOf(resistanceS);
            float P = ConverterCalculations.calculatePower(V, C);
            power.setText(Float.toString(P));
        }

        // calculate power and display
        //float P = ConverterCalculations.calculatePower(V, C);
        //power.setText(Float.toString(P));
    }

    public void zeronullCheck (){
        String v = voltage.getText().toString();
        String c = current.getText().toString();
        String r = resistance.getText().toString();
        System.out.println("ok:" + c + ":ok");
        if (v.equals("")) {
            voltage.setText("1");
            Toast.makeText(getApplicationContext(),"Variable must have a value",Toast.LENGTH_SHORT).show();
        } else if (c.equals("")) {
            current.setText("1");
            Toast.makeText(getApplicationContext(),"Variable must have a value",Toast.LENGTH_SHORT).show();
        } else if (r.equals("")){
            resistance.setText("1");
            Toast.makeText(getApplicationContext(),"Variable must have a value",Toast.LENGTH_SHORT).show();
        }

        v = voltage.getText().toString();
        c = current.getText().toString();
        r = resistance.getText().toString();
        float V = Float.parseFloat(v);
        float C = Float.parseFloat(c);
        float R = Float.parseFloat(r);
        if (V <= 0) {
            voltage.setText("1");
            Toast.makeText(getApplicationContext(),"Variable must be bigger than 0",Toast.LENGTH_SHORT).show();
        } else if (C <= 0) {
            current.setText("1");
            Toast.makeText(getApplicationContext(),"Variable must be bigger than 0",Toast.LENGTH_SHORT).show();
        } else if (R <= 0){
            resistance.setText("1");
            Toast.makeText(getApplicationContext(),"Variable must be bigger than 0",Toast.LENGTH_SHORT).show();
        }
    }

    // if powerResult is true this will run the required method to display values and vice versa
    public void checkPowerResult(){
        if (powerResult){
            enablePower();
        } else {
            disablePower();
        }
    }

    // show power calculation method
    public void enablePower(){
        power.setVisibility(View.VISIBLE);
        powerName.setVisibility(View.VISIBLE);
        powerUnit.setVisibility(View.VISIBLE);
    }

    // hide power calculation method
    public void disablePower(){
        power.setVisibility(View.INVISIBLE);
        powerName.setVisibility(View.INVISIBLE);
        powerUnit.setVisibility(View.INVISIBLE);
    }
}
