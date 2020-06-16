package myapplication.cp3406.jcu.edu.au.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void ohmsLawTest(){
        ConverterCalculations cc = new ConverterCalculations();

        // Set Values for calculation function
        String input = "Voltage";
        float V = 10;
        float C = 5;
        float R = 2;

        String expected = "10.0"; // expected outcome

        String[] resultStringArray = cc.organiseVariables(input, V, C, R);

        String result = resultStringArray[1]; // actual result

        assertEquals(expected, result); // compare answers
    }

    @Test
    public void powerTest(){
        ConverterCalculations cc = new ConverterCalculations();

        // Set Values for calculation function
        float V = 10;
        float C = 10;

        String expected = "100.0"; // expected outcome

        float resultFloat = cc.calculatePower(V, C);

        String result = Float.toString(resultFloat); // actual result

        assertEquals(expected, result); // compare answers
    }
}