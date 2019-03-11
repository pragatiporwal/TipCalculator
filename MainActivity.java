package com.example.dell.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText billamount;
    TextView tippercent,tiptotal,totalbillamount;
    ImageButton regular,good,excellent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatetip();
    }
    void calculatetip()
    {
        final float[] percentage = {0};
        float tiptot=0;
        float finalbillamount=0;
        final float[] billamount1 = {100};

        final float good_tippercent=15;
        final float regular_tippercent=10;
        final float excellent_tippercent=20;
        billamount = (EditText)findViewById(R.id.etbillamount);
        tippercent = (TextView) findViewById(R.id.tvtippercent);
        totalbillamount = (TextView)findViewById(R.id.tvTotalAmount);
        tiptotal = (TextView)findViewById(R.id.tvtiptotal);

        regular = (ImageButton)findViewById(R.id.regularService);
        good = (ImageButton)findViewById(R.id.goodService);
        excellent= (ImageButton)findViewById(R.id.excellentService);

        tippercent.setText(getString(R.string.main_msg_tippercent, percentage[0]));
        tiptotal.setText(getString(R.string.main_msg_tiptotal,tiptot));
        totalbillamount.setText(getString(R.string.main_msg_billtotalresult,finalbillamount));



        regular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=billamount.getText().toString();
                billamount1[0] =Float.parseFloat(s);
                percentage[0] =regular_tippercent;
                tippercent.setText(getString(R.string.main_msg_tippercent, regular_tippercent));

                float p=(percentage[0]*billamount1[0])/100;
                //tiptotal.setText(String.valueOf(p));
                tiptotal.setText(getString(R.string.main_msg_tiptotal,String.valueOf(p)));
                totalbillamount.setText(getString(R.string.main_msg_billtotalresult,billamount1[0]+p));
                //totalbillamount.setText(String.valueOf(billamount1[0]+p));



            }
        });

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage[0] =good_tippercent;
                String s=billamount.getText().toString();
                billamount1[0] =Float.parseFloat(s);
                percentage[0] =good_tippercent;
                tippercent.setText(getString(R.string.main_msg_tippercent,good_tippercent));
                float p=(percentage[0]*billamount1[0])/100;
                tiptotal.setText(getString(R.string.main_msg_tiptotal,String.valueOf(p)));
                totalbillamount.setText(getString(R.string.main_msg_billtotalresult,billamount1[0]+p));
            }
        });
        excellent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage[0] =excellent_tippercent;
                String s=billamount.getText().toString();
                billamount1[0] =Float.parseFloat(s);
                percentage[0] =excellent_tippercent;
                tippercent.setText(getString(R.string.main_msg_tippercent,excellent_tippercent));
                float p=(percentage[0]*billamount1[0])/100;
                tiptotal.setText(getString(R.string.main_msg_tiptotal,String.valueOf(p)));
                totalbillamount.setText(getString(R.string.main_msg_billtotalresult,billamount1[0]+p));
            }
        });

    }


}
