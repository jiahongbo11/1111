package com.example.calculator2;

import com.example.calculator2.ChangeUnit;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {

    //    private View view;
    //private String result;
    private EditText input , output;//文本框
    private EditText input2, output2;
    private EditText input3, output3;
    private EditText input4, output4;
    private EditText input5, output5;
    private EditText input6, output6;

    private Spinner mySpinner, mySpinner_top;//下拉框
    private Spinner mySpinner2, mySpinner_top2;
    private Spinner mySpinner3, mySpinner_top3;
    private Spinner mySpinner4, mySpinner_top4;
    private Spinner mySpinner5, mySpinner_top5;
    private Spinner mySpinner6, mySpinner_top6;
    private String unit1,unit2;//用来捕捉下拉框
    private String unit3,unit4;
    private String unit5,unit6;
    private String unit7,unit8;
    private String unit9,unit10;
    private String unit11,unit12;

    private Button Change1 , Change2, Change3, Change4, Change5, Change6;//换算
    private Button clean1;
    private Button clean2;
    private Button clean3;
    private Button clean4;
    private Button clean5;
    private Button clean6;

    private RadioButton[] radioButton=new RadioButton[6];
    private LinearLayout[] linearLayout=new LinearLayout[6];
    private RadioGroup radioGroup;


    private Button returnbtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        returnbtn = findViewById(R.id.return2);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        radioGroup = (RadioGroup)findViewById(R.id.group1);
        radioButton[0]=(RadioButton)findViewById(R.id.radio1);
        radioButton[1]=(RadioButton)findViewById(R.id.radio2);
        radioButton[2]=(RadioButton)findViewById(R.id.radio3);
        radioButton[3]=(RadioButton)findViewById(R.id.radio4);
        radioButton[4]=(RadioButton)findViewById(R.id.radio5);
        radioButton[5]=(RadioButton)findViewById(R.id.radio6);
        linearLayout[0]= (LinearLayout) findViewById(R.id.include1);
        linearLayout[1]= (LinearLayout) findViewById(R.id.include2);
        linearLayout[2]= (LinearLayout) findViewById(R.id.include3);
        linearLayout[3]= (LinearLayout) findViewById(R.id.include4);
        linearLayout[4]= (LinearLayout) findViewById(R.id.include5);
        linearLayout[5]= (LinearLayout) findViewById(R.id.include6);


        //通过RadioButton切换界面
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
            {
                Log.e("msg",checkedId+"checkedId");
                switch(checkedId)
                {
                    case R.id.radio1:
                        Log.e("msg",R.id.radio2+"R.id.radioButton2");

                        changeradio(0);
                        break;
                    case R.id.radio2:
                        changeradio(1);
                        break;
                    case R.id.radio3:
                        changeradio(2);
                        break;
                    case R.id.radio4:
                        changeradio(3);
                        break;
                    case R.id.radio5:
                        changeradio(4);
                        break;
                    case R.id.radio6:
                        changeradio(5);
                        break;
                }
            }
        });






        //长度
        input = findViewById(R.id.et_input);
        output = findViewById(R.id.tv_result);
        //下拉框
        mySpinner = findViewById(R.id.spinner);
        mySpinner_top = findViewById(R.id.spinner_top);
        //change 按钮
        Change1 = findViewById(R.id.change1);
        Change1.setOnClickListener(view -> change());
        clean1 = findViewById(R.id.clean1);
        clean1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
            }
        });


        //捕捉下拉框中的选项
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit1 = MainActivity3.this.getResources().getStringArray(R.array.Conversion)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mySpinner_top.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit2 = MainActivity3.this.getResources().getStringArray(R.array.Conversion)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //速度
        input2 = findViewById(R.id.et_input_speed);
        output2 = findViewById(R.id.tv_result_speed);
        //下拉框
        mySpinner2 = findViewById(R.id.spinner_speed);
        mySpinner_top2 = findViewById(R.id.spinner_top_speed);
        //change 按钮
        Change2 = findViewById(R.id.change2);
        Change2.setOnClickListener(view -> change2());
        clean2 = findViewById(R.id.clean2);
        clean2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input2.setText("");
                output2.setText("");
            }
        });
        //捕捉下拉框中的选项
        mySpinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit3 = MainActivity3.this.getResources().getStringArray(R.array.speed)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mySpinner_top2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit4 = MainActivity3.this.getResources().getStringArray(R.array.speed)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //温度
        input3 = findViewById(R.id.et_input_temperature);
        output3 = findViewById(R.id.tv_result_temperature);
        //下拉框
        mySpinner3 = findViewById(R.id.spinner_temperature);
        mySpinner_top3 = findViewById(R.id.spinner_top_temperature);
        //change 按钮
        Change3 = findViewById(R.id.change3);
        Change3.setOnClickListener(view -> change3());
        clean3 = findViewById(R.id.clean3);
        clean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input3.setText("");
                output3.setText("");
            }
        });
        //捕捉下拉框中的选项
        mySpinner3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit5 = MainActivity3.this.getResources().getStringArray(R.array.temperature)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mySpinner_top3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit6 = MainActivity3.this.getResources().getStringArray(R.array.temperature)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        //能量
        input4 = findViewById(R.id.et_input_energy);
        output4 = findViewById(R.id.tv_result_energy);
        //下拉框
        mySpinner4 = findViewById(R.id.spinner_energy);
        mySpinner_top4 = findViewById(R.id.spinner_top_energy);
        //change 按钮
        Change4 = findViewById(R.id.change4);
        Change4.setOnClickListener(view -> change4());
        clean4 = findViewById(R.id.clean4);
        clean4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input4.setText("");
                output4.setText("");
            }
        });
        //捕捉下拉框中的选项
        mySpinner4.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit7 = MainActivity3.this.getResources().getStringArray(R.array.energy)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mySpinner_top4.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit8 = MainActivity3.this.getResources().getStringArray(R.array.energy)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        //体积
        input5 = findViewById(R.id.et_input_volume);
        output5 = findViewById(R.id.tv_result_volume);
        //下拉框
        mySpinner5 = findViewById(R.id.spinner_volume);
        mySpinner_top5 = findViewById(R.id.spinner_top_volume);
        //change 按钮
        Change5 = findViewById(R.id.change5);
        Change5.setOnClickListener(view -> change5());
        clean5 = findViewById(R.id.clean5);
        clean5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input5.setText("");
                output5.setText("");
            }
        });
        //捕捉下拉框中的选项
        mySpinner5.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit9 = MainActivity3.this.getResources().getStringArray(R.array.volume)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mySpinner_top5.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit10 = MainActivity3.this.getResources().getStringArray(R.array.volume)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //体积
        input6 = findViewById(R.id.et_input_weight);
        output6 = findViewById(R.id.tv_result_weight);
        //下拉框
        mySpinner6 = findViewById(R.id.spinner_weight);
        mySpinner_top6 = findViewById(R.id.spinner_top_weight);
        //change 按钮
        Change6 = findViewById(R.id.change6);
        Change6.setOnClickListener(view -> change6());
        clean6 = findViewById(R.id.clean6);
        clean6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input6.setText("");
                output6.setText("");
            }
        });
        //捕捉下拉框中的选项
        mySpinner6.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit11 = MainActivity3.this.getResources().getStringArray(R.array.weight)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mySpinner_top6.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                unit12 = MainActivity3.this.getResources().getStringArray(R.array.weight)[arg2];
                //output.setText(unit);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }



    //用来切换界面的方法
    int old=0;
    public void changeradio(int i)
    {
        Log.e("msg",i+"");
        linearLayout[old].setVisibility(View.INVISIBLE);
        linearLayout[i].setVisibility(View.VISIBLE);
        old=i;
    }



    //用来转换的方法
    public void change(){
        String inputT = input.getText().toString();
        Float outputT;

        ChangeUnit c = new ChangeUnit();

        outputT = c.ChangetoUnit(unit1,inputT,unit2);

        output.setText(String.valueOf(outputT));


    }

    public void change2(){
        String inputT = input2.getText().toString();
        Float outputT;

        ChangeUnit c = new ChangeUnit();

        outputT = c.ChangetoUnitspeed(unit3,inputT,unit4);

        output2.setText(String.valueOf(outputT));


    }

    public void change3(){
        String inputT = input3.getText().toString();
        Float outputT;

        ChangeUnit c = new ChangeUnit();

        outputT = c.ChangetoUnittemperature(unit5,inputT,unit6);

        output3.setText(String.valueOf(outputT));


    }
    public void change4(){
        String inputT = input4.getText().toString();
        Float outputT;

        ChangeUnit c = new ChangeUnit();

        outputT = c.ChangetoUnitenergy(unit7,inputT,unit8);

        output4.setText(String.valueOf(outputT));


    }
    public void change5(){
        String inputT = input5.getText().toString();
        Float outputT;

        ChangeUnit c = new ChangeUnit();

        outputT = c.ChangetoUnitvolume(unit9,inputT,unit10);

        output5.setText(String.valueOf(outputT));


    }
    public void change6(){
        String inputT = input6.getText().toString();
        Float outputT;

        ChangeUnit c = new ChangeUnit();

        outputT = c.ChangetoUnitweight(unit11,inputT,unit12);

        output6.setText(String.valueOf(outputT));


    }


}