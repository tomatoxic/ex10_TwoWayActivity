package com.example.ex10_twowayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("세컨드 액티비티");

        Intent inIntent = getIntent();
        int num1 = inIntent.getIntExtra("Num1",0);
        int num2 = inIntent.getIntExtra("Num2",0);
        String type = inIntent.getStringExtra("type");

        Button btnReturn = findViewById(R.id.btnReturn);

        // 계산 고르기
        if (type.equals("add")) {
            sum = num1 + num2;
        } else if (type.equals("sub")) {
            sum = num1 - num2;
        } else if (type.equals("mul")) {
            sum = num1 * num2;
        } else if (type.equals("div")) {
            sum = num1 / num2;
        }

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Result",sum);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}