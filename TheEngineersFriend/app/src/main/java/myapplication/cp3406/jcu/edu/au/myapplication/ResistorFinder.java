package myapplication.cp3406.jcu.edu.au.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ResistorFinder extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Map resistorBandColour;
    private Map resistorBandMultiplier;
    private TextView ResistorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_finder);

        // Set IDs and link to XML
        spinner1 = findViewById(R.id.firstBandSpinner);
        spinner2 = findViewById(R.id.secondBandSpinner);
        spinner3 = findViewById(R.id.thirdBandSpinner);
        spinner4 = findViewById(R.id.fourthBandSpinner);
        spinner5 = findViewById(R.id.fifthBandSpinner);
        ResistorValue = findViewById(R.id.resistorValue);

        // Setup Colour Dictionary
        DictionarySetup();
    }

    public void CalculateResult(View view) {
        // Get values from spinners and then cross refernce with dictionary to get numbers
        String band1 = (String)resistorBandColour.get(spinner1.getSelectedItem().toString());
        String band2 = (String)resistorBandColour.get(spinner2.getSelectedItem().toString());
        String band3 = (String)resistorBandColour.get(spinner3.getSelectedItem().toString());
        String band4 = (String)resistorBandColour.get(spinner4.getSelectedItem().toString());
        String band5 = (String)resistorBandMultiplier.get(spinner5.getSelectedItem().toString());

        // Put numbers together as resistor value
        String bandResult = "" + band1 + band2 + band3 + band4 + band5;

        // Set value for text box
        ResistorValue.setText(bandResult);

    }

    public void DictionarySetup ()  {
        // Make dictionaries
        resistorBandColour = new HashMap<String, String>();
        resistorBandMultiplier = new HashMap<String, String>();

        // Add values to dictionary
        resistorBandColour.put("Blank", "");
        resistorBandColour.put("Black", "0");
        resistorBandColour.put("Brown", "1");
        resistorBandColour.put("Red", "2");
        resistorBandColour.put("Orange", "3");
        resistorBandColour.put("Yellow", "4");
        resistorBandColour.put("Green", "5");
        resistorBandColour.put("Blue", "6");
        resistorBandColour.put("Violet", "7");
        resistorBandColour.put("Grey", "8");
        resistorBandColour.put("White", "9");

        resistorBandMultiplier.put("Black", "Ω");
        resistorBandMultiplier.put("Brown", "0Ω");
        resistorBandMultiplier.put("Red", "00Ω");
        resistorBandMultiplier.put("Orange", "kΩ");
        resistorBandMultiplier.put("Yellow", "0kΩ");
        resistorBandMultiplier.put("Green", "00kΩ");
        resistorBandMultiplier.put("Blue", "MΩ");
        resistorBandMultiplier.put("Violet", "0MΩ");
        resistorBandMultiplier.put("Grey", "00MΩ");
        resistorBandMultiplier.put("White", "GΩ");
    }
}
