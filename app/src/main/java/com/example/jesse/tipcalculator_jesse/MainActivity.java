package com.example.jesse.tipcalculator_jesse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View view){
        EditText input = findViewById(R.id.TotalAmount);
        String inputBill = input.getText().toString();
        EditText inputPeople = findViewById(R.id.PeopleAmount);
        String people = inputPeople.getText().toString();
        float peopleN = Float.valueOf(people);
        EditText customInput = findViewById(R.id.CustomTip);
        String customTip = customInput.getText().toString();
        float custom = Float.valueOf(customTip);
        float bill = Float.valueOf(inputBill);
        float totalBill = 0;
        RadioButton twelve = findViewById(R.id.Twelve);
        RadioButton fifteen = findViewById(R.id.Fifteen);
        RadioButton eighteen = findViewById(R.id.Eighteen);
        RadioButton customButton = findViewById(R.id.Other);


        float tipAmount;

        if(twelve.isChecked()){
            tipAmount = (bill * 12 / 100);
            totalBill = (tipAmount + bill) / peopleN;
        }
        else if(fifteen.isChecked()){
            tipAmount = (bill * 15 / 100);
            totalBill = (tipAmount + bill) / peopleN;
        }
        else if(eighteen.isChecked()){
            tipAmount = (bill * 18 / 100);
            totalBill = (tipAmount + bill) / peopleN;
        }
        else if(customButton.isChecked()){
            tipAmount = (bill * custom / 100);
            totalBill = (tipAmount + bill) / peopleN;
        }

        TextView total = findViewById(R.id.Total);
        total.setText(String.format("Your total will be $%.2f.", totalBill));
    }
}
