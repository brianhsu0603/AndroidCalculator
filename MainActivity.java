package com.example.a277lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private TextView Screen;
    private Button C, Power, Back, Div, Mul, Plus, Sub, Equals, Nine, Eight, Seven, Six, Five, Four, Three, Two, One, Zero;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen = findViewById(R.id.screen);
        C = findViewById(R.id.c);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.divide);
        Mul = findViewById(R.id.multiply);
        Plus = findViewById(R.id.plus);
        Sub = findViewById(R.id.subtract);
        Equals = findViewById(R.id.equals);
        Nine = findViewById(R.id.nine);
        Eight = findViewById(R.id.eight);
        Seven = findViewById(R.id.seven);
        Six = findViewById(R.id.six);
        Five = findViewById(R.id.five);
        Four = findViewById(R.id.four);
        Three = findViewById(R.id.three);
        Two = findViewById(R.id.two);
        One = findViewById(R.id.one);
        Zero = findViewById(R.id.zero);
    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = "";
                break;
            case "=":
                Solve();
                break;
            case "DEL":
                String nextText = input.substring(0, input.length() - 1);
                input = nextText;
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/") || data.equals("x") || data.equals("^")) {
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }

    private void Solve() {
        if (input.split("x").length == 2) {
            String number[] = input.split("x");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            } catch (Exception e) {
            }

        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch (Exception e) {
            }

        } else if (input.split("\\^").length == 2) {
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow+"";
            } catch (Exception e) {
            }

        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            } catch (Exception e) {
            }

        } else if (input.split("-").length > 1) {
            String number[] = input.split("-");
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double sub = 0;
                if (number.length == 2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if (number.length == 3){
                   sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }

                input = sub+"";
            }
            catch (Exception e) {
            }

        }
        String n[] = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }
        }
        Screen.setText(input);

    }
}

