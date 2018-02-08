package com.example.jesse.tipcalculator_jesse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    /*
    @Override
    protected void onSaveInstanceState (Bundle outState) {

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){

    }
    */
    boolean values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void main(View view){
        EditText input = findViewById(R.id.TotalAmount);
        String inputBill = input.getText().toString();
        EditText inputPeople = findViewById(R.id.PeopleAmount);
        String people = inputPeople.getText().toString();
        if(TextUtils.isEmpty(inputBill)){
            input.setError("You did not input a value for the bill!");
            values = false;
            return;
        }
        if(TextUtils.isEmpty(people)){
            inputPeople.setError("You did not input a number of people!");
            values = false;
            return;
        }
        else{
            values = true;
        }
        if(values == true){
            calculate();
        }
    }
    public void calculate(){
            EditText input = findViewById(R.id.TotalAmount);
            String inputBill = input.getText().toString();
            EditText inputPeople = findViewById(R.id.PeopleAmount);
            String people = inputPeople.getText().toString();
            EditText customInput = findViewById(R.id.CustomTip);
            String customTip = customInput.getText().toString();
            float custom = Float.valueOf(customTip);
            float peopleN = Float.valueOf(people);
            float bill = Float.valueOf(inputBill);
            float totalBill = 0;
            RadioButton twelve = findViewById(R.id.Twelve);
            RadioButton fifteen = findViewById(R.id.Fifteen);
            RadioButton eighteen = findViewById(R.id.Eighteen);
            RadioButton customButton = findViewById(R.id.Other);
            float tipAmount;

            if(twelve.isChecked()){
                twelve.setError(null);
                fifteen.setError(null);
                eighteen.setError(null);
                customButton.setError(null);
                tipAmount = (bill * 12 / 100);
                totalBill = (tipAmount + bill) / peopleN;
            }
            else if(fifteen.isChecked()){
                twelve.setError(null);
                fifteen.setError(null);
                eighteen.setError(null);
                customButton.setError(null);
                tipAmount = (bill * 15 / 100);
                totalBill = (tipAmount + bill) / peopleN;
            }
            else if(eighteen.isChecked()){
                twelve.setError(null);
                fifteen.setError(null);
                eighteen.setError(null);
                customButton.setError(null);
                tipAmount = (bill * 18 / 100);
                totalBill = (tipAmount + bill) / peopleN;
            }
            else if(customButton.isChecked()){
                twelve.setError(null);
                fifteen.setError(null);
                eighteen.setError(null);
                customButton.setError(null);
                if(customInput == null){
                    customButton.setError("Set a value here.");
                }
                if(custom < 12){
                    customButton.setError("Please tip an amount of 12% or more.");
                    return;
                }
                tipAmount = (bill * custom / 100);
                totalBill = (tipAmount + bill) / peopleN;
            }
            else{
                twelve.setError("Please select an amount to tip");
                fifteen.setError("Please select an amount to tip");
                eighteen.setError("Please select an amount to tip");
                customButton.setError("Please select an amount to tip");
                return;
            }
            TextView total = findViewById(R.id.Total);
            TextView billTotal = findViewById(R.id.billTotal);
            billTotal.setText(String.format("The total of the bill is $%.2f.", totalBill));
            total.setText(String.format("The amount for you to tip will be $%.2f.", tipAmount / 10));
        }
}
