package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    TextView show;
    int flag=0;
    int count=0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        show=findViewById(R.id.winner);


    }
    public void check(View view) {
        Button btnCurrent = (Button) view;
        if (btnCurrent.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
            } else {
                btnCurrent.setText("O");
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //condition
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    show.setText("Winner is "+b1);
                    newgame();
                } else if (b4.equals(b5) && b5.equals(b6) && !b6.equals("")) {
                    show.setText("Winner is "+b4);
                    newgame();
                } else if (b7.equals(b8) && b8.equals(b9) && !b9.equals("")) {
                    show.setText("Winner is "+b8);;
                    newgame();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    show.setText("Winner is "+b1);
                    newgame();
                } else if (b2.equals(b5) && b5.equals(b8) && !b5.equals("")) {
                    show.setText("Winner is "+b2);
                    newgame();
                } else if (b3.equals(b6) && b6.equals(b9) && !b9.equals("")) {
                    show.setText("Winner is "+b3);
                    newgame();
                } else if (b1.equals(b5) && b5.equals(b9) && !b9.equals("")) {
                    show.setText("Winner is "+b1);
                    newgame();
                } else if (b3.equals(b5) && b5.equals(b7) && !b5.equals("")) {
                    show.setText("Winner is "+b3);
                    newgame();
                }else if(count==9){
                    newgame();
                }

            }

        }
    }
    public void newgame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        flag=0;
        count=0;

    }
}