package com.example.android_no2_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_num2_bmicompute.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(compute_bmi);
    }
    private View.OnClickListener compute_bmi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText findheight = (EditText)findViewById(R.id.edit1);
            EditText findweight = (EditText)findViewById(R.id.edit2);
            double height = Double.parseDouble(findheight.getText().toString())/100;
            double weight = Double.parseDouble(findweight.getText().toString());
            double bmi = weight / (height * height);
            TextView outputsuggest = (TextView)findViewById(R.id.text3);
            outputsuggest.setText(getText(R.string.bmi_result)
                    + nf.format(bmi));
            TextView makeps = (TextView)findViewById(R.id.text4);
            if (bmi < 18)
                makeps.setText(R.string.advice_light);
            else if (bmi > 24)
                makeps.setText(R.string.advice_heavy);
            else
                makeps.setText(R.string.advice_average);
        }
    };
}