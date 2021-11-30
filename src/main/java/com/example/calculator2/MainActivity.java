package com.example.calculator2;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //控制DRG按键，true为角度，false为弧度
    //public boolean drg_flag = true;
    //π值：3.14
    public double pi=4*Math.atan(1);

    private EditText Input;
    boolean clear_flag;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button clearBtn;
    private Button divBtn;
    private Button aluBtn;
    private Button delBtn;
    private Button subBtn;
    private Button addBtn;
    private Button resultBtn;
    private Button dianBtn;
    private Button percentBtn;

    private Button leftBtn;
    private Button rightBtn;
    private Button sqrtBtn;
    private Button squBtn;

    private Button sin, cos, tan, log, ln;

    private Button exitBtn;


//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        if(newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
//            getSupportActionBar().hide();//隐藏标题
//        super.onConfigurationChanged(newConfig);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();//隐藏标题

        Configuration mConfiguration = this.getResources().getConfiguration();
        //获取屏幕方向
        int ori = mConfiguration.orientation;
        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {

            getSupportActionBar().hide();//隐藏标题
            //横屏
        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {

            //竖屏
        }




        Input = (EditText) findViewById(R.id.input);
//        final TextView Output=(TextView) findViewById(R.id.Output);

        btn0 = (Button) findViewById(R.id.zero);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);

        //运算符
        clearBtn = (Button) findViewById(R.id.clear);//清除
        divBtn = (Button) findViewById(R.id.div);//÷
        aluBtn = (Button) findViewById(R.id.alu);//×
        delBtn = (Button) findViewById(R.id.del);//删除

        subBtn = (Button) findViewById(R.id.sub);//-
        addBtn = (Button) findViewById(R.id.add);//+
        resultBtn = (Button) findViewById(R.id.result);//=
        dianBtn = (Button) findViewById(R.id.dian);//.
        percentBtn = (Button) findViewById(R.id.percent);//%
        leftBtn = (Button) findViewById(R.id.left9);//（
        rightBtn = (Button) findViewById(R.id.right0);//）
        sqrtBtn = (Button) findViewById(R.id.sqrt) ;
        squBtn = (Button) findViewById(R.id.squ);

        sin = (Button)findViewById(R.id.sin);
        cos = (Button)findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        log = (Button) findViewById(R.id.log);
        ln = (Button) findViewById(R.id.ln);

        Button moreBtn = (Button) findViewById(R.id.more);
        Button more2Btn = (Button) findViewById(R.id.more2);
        Button menuBtn = (Button) findViewById(R.id.menuBtn) ;




        btn0.setOnClickListener( this);
        btn1.setOnClickListener( this);
        btn3.setOnClickListener( this);
        btn4.setOnClickListener( this);
        btn5.setOnClickListener( this);
        btn6.setOnClickListener( this);
        btn7.setOnClickListener( this);
        btn8.setOnClickListener( this);
        btn9.setOnClickListener( this);
        btn2.setOnClickListener( this);
        clearBtn.setOnClickListener( this);
        divBtn.setOnClickListener( this);
        aluBtn.setOnClickListener( this);
        delBtn.setOnClickListener( this);
        subBtn.setOnClickListener( this);
        addBtn.setOnClickListener( this);
        resultBtn.setOnClickListener( this);
        dianBtn.setOnClickListener(this);
        percentBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        squBtn.setOnClickListener(this);
        sqrtBtn.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        ln.setOnClickListener(this);



        try {//更多,切换到另一个Activity
            moreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
            });

            more2Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent1);
                }
            });
            exitBtn = (Button) findViewById(R.id.Exit11);
            exitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.exit(0);
                }
            });

            //点击按钮打开弹出式菜单
            menuBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //创建mennu
                    PopupMenu popupMenu = new PopupMenu(MainActivity.this,menuBtn);
                    //加载菜单资源
                    popupMenu.getMenuInflater().inflate(R.menu.menu1,popupMenu.getMenu());

                    //菜单监听
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()){
                                case R.id.help:
                                    Toast.makeText(MainActivity.this,"这是帮助文本",Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.exit:
                                    System.exit(0);
                                    break;
                            }
                            return true;
                        }
                    });

                    try {
                        Field field = popupMenu.getClass().getDeclaredField("mm");
                        field.setAccessible(true);
                        MenuPopupHelper menuPopupHelper = (MenuPopupHelper) field.get(popupMenu);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    popupMenu.show();
                }
            });

        } catch (Exception e) {

        }







    }

    //计算
    final int MAX = 500;
    public void getResult(String input){

        String str = input;//提取表达式

        int weightPlus = 0, topOp = 0,
                topNum = 0, flag = 1, weightTemp = 0;
        //weightPlus为同一（）下的基本优先级，weightTemp临时记录优先级的变化
        //topOp为weight[]，operator[]的计数器；topNum为number[]的计数器
        //flag为正负数的计数器，1为正数，-1为负数

        int weight[];  //保存operator栈中运算符的优先级，以topOp计数

        double number[];  //保存数字，以topNum计数

        char ch, ch_gai, operator[];//operator[]保存运算符，以topOp计数

        String num;//记录数字，str以+-×÷()sctgl!√^分段，+-×÷()sctgl!√^字符之间的字符串即为数字
        weight = new int[MAX];//保存运算符的优先级
        number = new double[MAX];//保存数字
        operator = new char[MAX];//保存运算符

        StringTokenizer expToken = new StringTokenizer(str,"+-×÷()sctgl!√^");//将字符串分隔

        int i = 0;
        while (i < str.length()){
            ch = str.charAt(i);

            //判断正负数
            if (i == 0) {
                if (ch == '-')
                    flag = -1;
            } else if(str.charAt(i-1) == '(' && ch == '-')
                flag = -1;


            //取得数字
            if(ch <= '9' && ch >= '0' || ch == '.' || ch == 'E'){
                num = expToken.nextToken();
                ch_gai = ch;


                while(i < str.length() && (ch_gai <= '9' && ch_gai >= '0'|| ch_gai == '.' || ch_gai == 'E')){
                    ch_gai = str.charAt(i++);

                }

                //将指针退回
                if(i >= str.length())
                    i -= 1;
                else{
                    i -= 2;
                }

                if(num.compareTo(".") == 0)
                    number[topNum++] = 0;
                else{
                    number[topNum++] = Double.parseDouble(num)*flag;
                    flag = 1;
                }

            }

            //运算符的优先级
            if(ch == '(')
                weightPlus += 4;
            if(ch == ')')
                weightPlus -= 4;
            if(ch == '-' && flag == 1 || ch == '+' || ch == '×'|| ch == '÷' ||
                    ch == 's' ||ch == 'c' || ch == 't' || ch == 'g' || ch == 'l' ||
                    ch == '!' || ch == '√' || ch == '^'){

                switch (ch){
                    // +-优先级为1
                    case '+':
                    case '-':
                        weightTemp = 1 + weightPlus;
                        break;
                    //x÷的优先级稍高，为2
                    case '×':
                    case '÷':
                        weightTemp = 2 + weightPlus;
                        break;
                    //sincos之类优先级为3
                    case 's':
                    case 'c':
                    case 't':
                    case 'g':
                    case 'l':
                    case '!':
                        weightTemp = 3 + weightPlus;
                        break;
                    //其余优先级为4
                    //case '^':
                    //case '√':
                    default:
                        weightTemp = 4 + weightPlus;
                        break;

                }

                //如果当前优先级大于堆栈顶部元素，则直接入栈
                if (topOp == 0 || weight[topOp-1] < weightTemp) {
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch;
                    topOp++;
                    //否则将堆栈中运算符逐个取出，直到当前堆栈顶部运算符的优先级小于当前运算符
                }else {
                    while (topOp > 0 && weight[topOp-1] >= weightTemp) {
                        switch (operator[topOp-1]) {
                            //取出数字数组的相应元素进行运算
                            case '+':
                                number[topNum-2]+=number[topNum-1];
                                break;
                            case '-':
                                number[topNum-2]-=number[topNum-1];
                                break;
                            case '×':
                                number[topNum-2]*=number[topNum-1];
                                break;
                            //判断除数为0的情况
                            case '÷':
                                if (number[topNum-1] == 0) {
                                    //showError(1,str_old);
                                    return;
                                }
                                number[topNum-2]/=number[topNum-1];
                                break;
                            case '√':
                                if(number[topNum-1] == 0 || (number[topNum-2] < 0 &&
                                        number[topNum-1] % 2 == 0)) {
                                    return;
                                }
                                number[topNum-2] =
                                        Math.pow(number[topNum-2], 1/number[topNum-1]);
                                break;
                            case '^':
                                number[topNum-2] =
                                        Math.pow(number[topNum-2], number[topNum-1]);
                                break;
                            //计算时进行角度弧度的判断及转换
                            //sin
                            case 's':

                                number[topNum-1] = Math.sin((number[topNum-1]/180)*pi);

                                topNum++;
                                break;
                            //cos
                            case 'c':

                                number[topNum-1] = Math.cos((number[topNum-1]/180)*pi);

                                topNum++;
                                break;
                            //tan
                            case 't':

                                if((Math.abs(number[topNum-1])/90)%2 == 1) {

                                    return;
                                }
                                number[topNum-1] = Math.tan((number[topNum-1]/180)*pi);
                                topNum++;
                                break;
                            //log
                            case 'g':
                                if(number[topNum-1] <= 0) {

                                    return;
                                }
                                number[topNum-1] = Math.log10(number[topNum-1]);
                                topNum++;
                                break;
                            //ln
                            case 'l':
                                if(number[topNum-1] <= 0) {
                                    //showError(2,str_old);
                                    return;
                                }
                                number[topNum-1] = Math.log(number[topNum-1]);
                                topNum++;
                                break;
                            //阶乘
                            case '!':
                                if(number[topNum-1] > 170) {

                                    return;
                                } else if(number[topNum-1] < 0) {

                                    return;
                                }
                                number[topNum-1] = N(number[topNum-1]);
                                topNum++;
                                break;
                        }
                        //继续取堆栈的下一个元素进行判断
                        topNum--;
                        topOp--;
                    }
                    //将运算符如堆栈
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch;
                    topOp++;
                }

            }

            i++;
        }


        //依次取出堆栈的运算符进行运算
        while (topOp>0) {
            //+-x直接将数组的后两位数取出运算
            switch (operator[topOp-1]) {
                case '+':
                    number[topNum-2]+=number[topNum-1];
                    break;
                case '-':
                    number[topNum-2]-=number[topNum-1];
                    break;
                case '×':
                    number[topNum-2]*=number[topNum-1];
                    break;
                //涉及到除法时要考虑除数不能为零的情况
                case '÷':
                    if (number[topNum-1] == 0) {
                        //showError(1,str_old);
                        return;
                    }
                    number[topNum-2]/=number[topNum-1];
                    break;
                case '√':
                    if(number[topNum-1] == 0 || (number[topNum-2] < 0 &&
                            number[topNum-1] % 2 == 0)) {
                        //showError(2,str_old);
                        return;
                    }
                    number[topNum-2] =
                            Math.pow(number[topNum-2], 1/number[topNum-1]);
                    break;
                case '^':
                    number[topNum-2] =
                            Math.pow(number[topNum-2], number[topNum-1]);
                    break;
                //sin
                case 's':

                    number[topNum-1] = Math.sin((number[topNum-1]/180)*pi);

                    topNum++;
                    break;
                //cos
                case 'c':

                    number[topNum-1] = Math.cos((number[topNum-1]/180)*pi);

                    topNum++;
                    break;
                //tan
                case 't':

                    if((Math.abs(number[topNum-1])/90)%2 == 1) {

                        return;
                    }
                    number[topNum-1] = Math.tan((number[topNum-1]/180)*pi);

                    topNum++;
                    break;
                //对数log
                case 'g':
                    if(number[topNum-1] <= 0) {

                        return;
                    }
                    number[topNum-1] = Math.log10(number[topNum-1]);
                    topNum++;
                    break;
                //自然对数ln
                case 'l':
                    if(number[topNum-1] <= 0) {

                        return;
                    }
                    number[topNum-1] = Math.log(number[topNum-1]);
                    topNum++;
                    break;
                //阶乘
                case '!':
                    if(number[topNum-1] > 170) {

                        return;
                    } else if(number[topNum-1] < 0) {

                        return;
                    }
                    number[topNum-1] = N(number[topNum-1]);
                    topNum++;
                    break;
            }
            //取堆栈下一个元素计算
            topNum--;
            topOp--;
        }

        Input.setText(String.valueOf(FP(number[0])));




        if(str==null||str.equals("")){
            return;
        }

        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;



    }


    public double FP(double n) {

        DecimalFormat format = new DecimalFormat("0.##########");
        return Double.parseDouble(format.format(n));
    }



//    public void getResult(){
//        String exp = Input.getText().toString();
//        if(exp==null||exp.equals("")){
//            return;
//        }
//        if(!exp.contains(" ")){
//            return;
//        }
//        if(clear_flag){
//            clear_flag = false;
//            return;
//        }
//        clear_flag = true;
//        double result = 0;
//
//        String s1 = exp.substring(0,exp.indexOf(" "));
//        //运算符
//        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
//        //运算符后的数字
//        String s2 = exp.substring(exp.indexOf(" ")+3);
//
//        if(!s1.equals("")&&!s2.equals("")) {//如果包含小数点的运算
//            double d1 = Double.parseDouble(s1);//则数字都是double类型
//            double d2 = Double.parseDouble(s2);
//            if (op.equals("+")) {//如果是 +
//                result = d1 + d2;
//            } else if (op.equals("-")) {
//                result = d1 - d2;
//            } else if (op.equals("*")) {
//                result = d1 * d2;
//            } else if (op.equals("/")) {
//                if (d2 == 0) { //如果被除数是0
//                    result = 0; //则结果是0
//                }
//                else {//否则执行正常是除法运算
//                    result = d1 / d2;
//                }
//            } else if(op.equals("^")){
//                result = Math.pow(d1,d2);
//            }
//
//
//            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {//如果是整数类型
//                int r = (int) result; //都是整形
//                Input.setText(r + "");
//            } else{
//                Input.setText(result + "");
//            }
//        }else if(!s1.equals("") && s2.equals("")){//如果是只输入运算符前的数
//            Input.setText(exp);//直接返回当前文本框的内容
//        }else if(s1.equals("") && !s2.equals("")){//如果是只输入运算符后面的数
//            double d2 = Double.parseDouble(s2);
//
//            //运算符前没有输入数字
//            if (op.equals("+")) {
//                result = 0 + d2;
//            } else if (op.equals("-")) {
//                result = 0 - d2;
//            } else if (op.equals("*")) {
//                result = 0;
//            } else if (op.equals("/")) {
//                result = 0;
//            } else if(op.equals("√")){
//                result = Math.sqrt(d2);
//            }
//
//            if (!s1.contains(".") && !s2.contains(".")) {
//                int r = (int) result;
//                Input.setText(r + "");
//            } else{
//                Input.setText(result + "");
//            }
//        }else {
//            Input.setText("");
//        }
//
//
//
//
//    }


    @Override
    public void onClick(View view) {
        String inputText = (String)Input.getText().toString();


        inputText = inputText.replaceAll("sin", "s");
        inputText = inputText.replaceAll("cos", "c");
        inputText = inputText.replaceAll("tan", "t");
        inputText = inputText.replaceAll("log", "g");
        inputText = inputText.replaceAll("ln", "l");
        inputText = inputText.replaceAll("n!", "!");

        switch (view.getId()){
            case R.id.zero:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.dian:
            case R.id.add:
            case R.id.sub:
            case R.id.alu:
            case R.id.div:
            case R.id.sqrt:
            case R.id.squ:
            case R.id.left9:
            case R.id.right0:
            case R.id.sin:
            case R.id.cos:
            case R.id.tan:
            case R.id.log:
            case R.id.ln:
            case R.id.percent:

                Input.setText(inputText + ((Button)view).getText() );

                break;
            case R.id.del:
                if(inputText != null && !inputText.equals("")) {//如果获取到的内容为空
                    Input.setText(inputText.substring(0, inputText.length() - 1));
                }
                break;
            case R.id.result:
                getResult(inputText);

                break;
            case R.id.clear:
                Input.setText("");


        }


    }

    //阶乘
    public double N(double n) {
        int i = 0;
        double sum = 1;
        //依次将小于等于n的值相乘
        for(i = 1;i <= n;i++) {
            sum = sum*i;
        }
        return sum;
    }

}