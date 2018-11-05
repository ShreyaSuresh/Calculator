package com.example.shrey.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button first;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button equal;
    Button plus;
    Button divide;
    Button times;
    Button clear;

    TextView output;

    String answer = "";
    String errorMessage = "Error";

    ArrayList <String> symbols = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.id_Button_one);
        two = findViewById(R.id.id_Button_two);
        three = findViewById(R.id.id_Button_three);
        four = findViewById(R.id.id_Button_four);
        five = findViewById(R.id.id_Button_five);
        six = findViewById(R.id.id_Button_six);
        seven = findViewById(R.id.id_Button_seven);
        eight = findViewById(R.id.id_Button_eight);
        nine = findViewById(R.id.id_Button_nine);
        zero = findViewById(R.id.id_Button_zero);
        equal = findViewById(R.id.id_Button_eqiual);
        plus = findViewById(R.id.id_Button_plus);
        divide = findViewById(R.id.id_Button_divide);
        times = findViewById(R.id.id_Button_multiply);
        clear = findViewById(R.id.id_Button_clear);

        output = findViewById(R.id.id_textView_answer);
    }

    public void clickedOne(View view){
        answer+="1";
        output.setText(answer);
    }
    public void clickedTwo(View view){
        answer+="2";
        output.setText(answer);
    }
    public void clickedThree(View view){
        answer+="3";
        output.setText(answer);
    }
    public void clickedFour(View view){
        answer+="4";
        output.setText(answer);
    }
    public void clickedFive(View view){
        answer+="5";
        output.setText(answer);
    }
    public void clickedSix(View view){
        answer+="6";
        output.setText(answer);
    }
    public void clickedSeven(View view){
        answer+="7";
        output.setText(answer);
    }
    public void clickedEight(View view){
        answer+="8";
        output.setText(answer);
    }
    public void clickedNine(View view){
        answer+="9";
        output.setText(answer);
    }
    public void clickedZero(View view){
        answer+="0";
        output.setText(answer);
    }
    public void add(View view){
        answer+="+";
        output.setText(answer);
    }
    public void subtract(View view){
        answer+="-";
        output.setText(answer);
    }
    public void divide(View view){
        answer+="/";
        output.setText(answer);
    }
    public void times(View view){
        answer+="*";
        output.setText(answer);
    }
    public void result(View view){
       String finalResult = "";
       StringTokenizer tokenizer = new StringTokenizer(answer, "+-*/",  true);
       while (tokenizer.hasMoreTokens() ) {
           symbols.add(tokenizer.nextToken());
       }
       String fr = "Error";
        double finalAnswer = 0.0;
        double firstNum;
        double secondNum;
         try {
              //order of operations --> mul & div before add & sub
              finalResult = "";

              answer = "";
              for (int i = 0; i < symbols.size(); i++) {
                  if (symbols.get(i).equals("*") || symbols.get(i).equals("/")) {
                      finalAnswer = 0.0;
                      firstNum = Double.parseDouble(symbols.get(i - 1));
                      secondNum = Double.parseDouble(symbols.get(i + 1));
                      if (symbols.get(i).equals("*"))
                          finalAnswer = firstNum * secondNum;
                      else {
                          finalAnswer = firstNum / secondNum;
                      }
                      symbols.remove(i + 1);
                      symbols.remove(i);
                      finalResult = finalAnswer + "";
                      answer = finalResult;
                      Log.d("suresh", finalResult);
                      symbols.set(i - 1, finalResult);
                      i--;
                      output.setText(answer);
                  }
              }
          }catch(Exception e) {
              if(finalAnswer>0.0)
                  output.setText(answer);
              else {
                  output.setText("Error");
              }
          }

          if(output.getText().equals("Infinity") || output.getText().equals("NaN")) {
              output.setText("Error");
              finalResult="";
              answer = "";
          }
         try{
            for (int i = 0; i < symbols.size(); i++) {
                finalAnswer = 0.0;
                if (symbols.get(i).equals("+") || symbols.get(i).equals("-")) {
                    firstNum = Double.parseDouble(symbols.get(i - 1));
                    secondNum = Double.parseDouble(symbols.get(i + 1));
                    if (symbols.get(i).equals("+")) {
                        finalAnswer = firstNum + secondNum;
                    } else
                        finalAnswer = firstNum - secondNum;
                    symbols.remove(i + 1);
                    symbols.remove(i);
                    finalResult = finalAnswer + "";
                    answer = finalResult;
                    Log.d("shreya", finalResult);
                    symbols.set(i - 1, finalResult);
                    i--;
                    output.setText(answer);
                }
            }
        }catch(Exception e){
              if(finalAnswer>0)
                  output.setText(answer);
              else
                output.setText("Error");
        }
        if(output.getText().equals("Infinity") || output.getText().equals("NaN")) {
            output.setText("Error");
            finalResult = "";
            answer = "";
        }
    }

    public void clearCalc(View view){
        answer="";
        output.setText(answer);
    }
}
