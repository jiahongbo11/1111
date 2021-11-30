package com.example.calculator2;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    private EditText edit2;
    private EditText edit8;
    private EditText edit10;
    private EditText edit16;

    private Button clear;
    private Button translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit2 = findViewById(R.id.Edit2);
        edit8 = findViewById(R.id.Edit8);
        edit10 = findViewById(R.id.Edit10);
        edit16 = findViewById(R.id.Edit16);

        clear = findViewById(R.id.clean);
        translate = findViewById(R.id.trans);

        translate.setOnClickListener(view -> Translate());



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit2.setText("");
                edit8.setText("");
                edit10.setText("");
                edit16.setText("");

            }
        });



        Button btnR = findViewById(R.id.btnReturn);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void Translate() {
        String binary = edit2.getText().toString();
        String octal = edit8.getText().toString();
        String decimal = edit10.getText().toString();
        String hex = edit16.getText().toString();

        if (!binary.equals("")) {
            int _binary = Integer.valueOf(binary,2);
            edit8.setText(Integer.toOctalString(_binary));
            edit10.setText("" + _binary);
            edit16.setText(Integer.toHexString(_binary));
        } else if (!octal.equals("")) {
            int _octal = Integer.valueOf(octal,8);
            edit2.setText(Integer.toBinaryString(_octal));
            edit10.setText("" + _octal);
            edit16.setText(Integer.toHexString(_octal));
        } else if (!decimal.equals("")) {
            edit2.setText(Integer.toBinaryString(Integer.parseInt(decimal)));
            edit8.setText(Integer.toOctalString(Integer.parseInt(decimal)));
            edit16.setText(Integer.toHexString(Integer.parseInt(decimal)));
        } else if (!hex.equals("")) {
            int _hex = Integer.valueOf(hex,16);
            edit2.setText(Integer.toBinaryString(_hex));
            edit8.setText(Integer.toOctalString(_hex));
            edit10.setText("" + _hex);
        } else {
            Toast.makeText(MainActivity2.this,"输入为空",Toast.LENGTH_LONG);
        }

    }
}