package myapplication.cp3406.jcu.edu.au.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;


public class SettingsActivity extends AppCompatActivity {

    static int SETTINGS_REQUEST = 1;
    private Switch power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        power = findViewById(R.id.power);

        // Get intent and read powerResult
        Intent intent = getIntent();
        Boolean powerResult = intent.getBooleanExtra("powerResult", false);

        // Ensure the state of switch is same when re -opening settings
        if (powerResult) {
            power.toggle();
        }
    }

    // Send users choice with intent for usage of other activities
    public void applySettings(View v){
        Boolean result = power.isChecked();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", result);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
