package com.example.ex10_twowayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");


        EditText edtNum1 = findViewById(R.id.edtNum1);
        EditText edtNum2 = findViewById(R.id.edtNum2);

        RadioGroup btnGroup = findViewById(R.id.btnGroup);
        RadioButton btnAdd = findViewById(R.id.btnAdd);
        RadioButton btnSub = findViewById(R.id.btnSub);
        RadioButton btnMul = findViewById(R.id.btnMul);
        RadioButton btnDiv = findViewById(R.id.btnDiv);

        Button btnNewActivity = findViewById(R.id.btnNewActivity);


        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                // 라디오 그룹의 버튼 선택 시 계산 유형 리턴
                switch (btnGroup.getCheckedRadioButtonId()) {
                    case (R.id.btnAdd):
                        intent.putExtra("type", "add");
                        break;
                    case (R.id.btnSub):
                        intent.putExtra("type", "sub");
                        break;
                    case (R.id.btnMul):
                        intent.putExtra("type", "mul");
                        break;
                    case (R.id.btnDiv):
                        intent.putExtra("type", "div");
                        break;
                }
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int resultValue = data.getIntExtra("Result", 0);
            Toast.makeText(getApplicationContext(), "결과 : " + resultValue
                    , Toast.LENGTH_SHORT).show();
        }
    }
}