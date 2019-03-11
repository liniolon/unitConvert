package com.liniolon.convert;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;
    private TextInputEditText txtInputNumber;
    private Spinner txtUnit;

    float inchToCM = 2.54f;
    float inchToM = 0.0254f;
    float inchToKM = 0.00002f;

    float cmToCM = 1f;
    float cmToM = 0.01f;
    float cmToKM = 0.00001f;
    float KM = 0.001f;

    Intent intent_1;

    float inputNumber = 0f;
    String getNumber;

    int p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setID();

        intent_1 = new Intent(this, ResultActivity.class);
//        sendRequest();


    }


    public float CalculateMultiply(float number1, float number2) {
        float result = number1 * number2;
        return result;
    }

    public float CalculateDevide(float number1, float number2) {
        float result = number1 / number2;
        return result;
    }

//    public void sendRequest() {
//        btnCalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }

    public void sendResult(View view) {
//        sendRequest();
        p = txtUnit.getSelectedItemPosition();
        try {
            getNumber = txtInputNumber.getText().toString();
            inputNumber = Float.parseFloat(getNumber);
        } catch (NumberFormatException e) {
            Log.e("ERRRRORRRR", "ERROR: " + e);
        }

        intent_1.putExtra("UNIT_1", "inch");
        intent_1.putExtra("UNIT_2", "centimeter");
        intent_1.putExtra("UNIT_3", "meter");
        intent_1.putExtra("UNIT_4", "kilometer");

        if (p == 3) {
            intent_1.putExtra("NUMBER_1", CalculateMultiply(inputNumber, inchToCM));
            intent_1.putExtra("NUMBER_2", CalculateMultiply(inputNumber, inchToM));
            intent_1.putExtra("NUMBER_3", CalculateMultiply(inputNumber, inchToKM));
            intent_1.putExtra("NUMBER_4", CalculateMultiply(inputNumber, 1));
            intent_1.putExtra("UNIT", "inch");

        } else if (p == 0) {
            intent_1.putExtra("NUMBER_1", CalculateMultiply(inputNumber, inchToCM));
            intent_1.putExtra("NUMBER_2", CalculateMultiply(inputNumber, cmToM));
            intent_1.putExtra("NUMBER_3", CalculateMultiply(inputNumber, cmToKM));
            intent_1.putExtra("NUMBER_4", CalculateMultiply(inputNumber, 1));
            intent_1.putExtra("UNIT", "cm");
        } else if(p == 1){
            intent_1.putExtra("NUMBER_1", CalculateMultiply(inputNumber, inchToM));
            intent_1.putExtra("NUMBER_2", CalculateMultiply(inputNumber, cmToM));
            intent_1.putExtra("NUMBER_3", CalculateMultiply(inputNumber, KM));
            intent_1.putExtra("NUMBER_4", CalculateMultiply(inputNumber, 1));
            intent_1.putExtra("UNIT", "m");
        } else if(p == 2){
            intent_1.putExtra("NUMBER_1", CalculateDevide(inputNumber, inchToKM));
            intent_1.putExtra("NUMBER_2", CalculateDevide(inputNumber, cmToKM));
            intent_1.putExtra("NUMBER_3", CalculateDevide(inputNumber, KM));
            intent_1.putExtra("NUMBER_4", CalculateMultiply(inputNumber, 1));
            intent_1.putExtra("UNIT", "km");

        }
        startActivity(intent_1);

    }

    public void setID() {
        btnCalculate = findViewById(R.id.btn_calculate);
        txtInputNumber = findViewById(R.id.txt_number);
        txtUnit = findViewById(R.id.txt_from_units);
    }


}
