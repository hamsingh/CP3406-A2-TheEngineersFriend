package myapplication.cp3406.jcu.edu.au.myapplication;

import java.text.DecimalFormat;

public class ConverterCalculations {


    public static String[] organiseVariables (String selection, float V, float C, float R) {
        // Answer Format
        DecimalFormat df = new DecimalFormat(".##");
        String results [] = new String [2];

        // Check the calculation type and read specific values and calculate result
        if (selection.equals("Voltage")) {
            float Voltage = C * R;
            Voltage = Float.valueOf(df.format(Voltage));
            String result = Float.toString(Voltage);
            results[0] = "voltage";
            results[1] = result;
        } else if (selection.equals("Current")) {
            float Current = V / R;
            Current = Float.valueOf(df.format(Current));
            String result = Float.toString(Current);
            results[0] = "current";
            results[1] = result;
        } else if (selection.equals("Resistance")) {
            float Resistance = V / C;
            Resistance = Float.valueOf(df.format(Resistance));
            String result = Float.toString(Resistance);
            results[0] = "resistance";
            results[1] = result;
        }
        return results;
    }
    public static float calculatePower (float V, float C){
        // Calculate Power
        float power = V * C;

        // return power in Watts
        return power;
    }
}
