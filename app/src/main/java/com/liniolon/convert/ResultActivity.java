package com.liniolon.convert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private TextView txtNumber1;
    private TextView txtNumber2;
    private TextView txtNumber3;
    private TextView txtNumber4;

    private TextView txtUnit1;
    private TextView txtUnit2;
    private TextView txtUnit3;
    private TextView txtUnit4;

    float number1;
    float number2;
    float number3;
    float number4;

    String unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setID();

        Bundle getNumber1 = getIntent().getExtras();

        try {
            number1 = getNumber1.getFloat("NUMBER_1");
            number2 = getNumber1.getFloat("NUMBER_2");
            number3 = getNumber1.getFloat("NUMBER_3");
            number4 = getNumber1.getFloat("NUMBER_4");
            unit = getNumber1.getString("UNIT");

            Log.e("UNIIIIT", unit);
        } catch (Exception e) {
            Log.e("ERRRRORRRR", "" + e);
        }

        txtNumber1.setText(number1 + "");
        txtNumber2.setText(number2 + "");
        txtNumber3.setText(number3 + "");
        txtNumber4.setText(number4 + "");


        if (unit.equals("cm")) {
            txtUnit4.setText("CM");
            txtUnit1.setText("INCH");
            txtUnit2.setText("M");
            txtUnit3.setText("KM");
        } else if (unit.equals("m")) {
            txtUnit4.setText("M");
            txtUnit1.setText("INCH");
            txtUnit2.setText("CM");
            txtUnit3.setText("KM");

        } else if (unit.equals("km")) {
            txtUnit4.setText("KM");
            txtUnit1.setText("INCH");
            txtUnit2.setText("CM");
            txtUnit3.setText("M");

        } else if (unit.equals("inch")) {
            txtUnit4.setText("INCH");
            txtUnit1.setText("M");
            txtUnit2.setText("CM");
            txtUnit3.setText("KM");

        }


    }


    public void setID() {
        txtNumber1 = findViewById(R.id.txt_number_1);
        txtNumber2 = findViewById(R.id.txt_number_2);
        txtNumber3 = findViewById(R.id.txt_number_3);
        txtNumber4 = findViewById(R.id.txt_result);

        txtUnit1 = findViewById(R.id.txt_unit_1);
        txtUnit2 = findViewById(R.id.txt_unit_2);
        txtUnit3 = findViewById(R.id.txt_unit_3);
        txtUnit4 = findViewById(R.id.txt_unit);

    }
}
