package com.example.android_10_trlredeem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TRL_Redeem_numbers extends AppCompatActivity {
    //個月中獎號碼
    String[][] winning={{"631","552","722","809","264"},{"270","506","409","136","022"},
            {"845","355","063","984","240"},{"420","012","818","928","899"},{"435","762","504","693","043","425"},
            {"970","388","508","710","585","633"}};
    static int chose=0;
    static String chosestring ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_r_l__redeem_numbers);
        TV_show();
    }
    private void TV_show(){
        //讀上頁傳值
        final TextView mtitle = findViewById(R.id.TV_title);
        final TextView mWinning1 = findViewById(R.id.TV_Winning1);
        final TextView mWinning2 = findViewById(R.id.TV_Winning2);
        final TextView mWinning3 = findViewById(R.id.TV_Winning3);
        final TextView mWinning4 = findViewById(R.id.TV_Winning4);
        final TextView mWinning5 = findViewById(R.id.TV_Winning5);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            chosestring = bundle.getString("chosestring");
            mtitle.setText(chosestring);
            chose = Integer.parseInt(bundle.getString("choseint"));
        }
        //輸出中獎號碼
        if(chose == 1){
            mWinning1.setText(winning[0][0]);
            mWinning2.setText(winning[0][1]);
            mWinning3.setText(winning[0][2]);
            mWinning4.setText(winning[0][3]);
            mWinning5.setText(winning[0][4]);
        }else if (chose == 2){
            mWinning1.setText(winning[1][0]);
            mWinning2.setText(winning[1][1]);
            mWinning3.setText(winning[1][2]);
            mWinning4.setText(winning[1][3]);
            mWinning5.setText(winning[1][4]);
        }else if (chose == 3){
            mWinning1.setText(winning[2][0]);
            mWinning2.setText(winning[2][1]);
            mWinning3.setText(winning[2][2]);
            mWinning4.setText(winning[2][3]);
            mWinning5.setText(winning[2][4]);
        }else if (chose == 4){
            mWinning1.setText(winning[3][0]);
            mWinning2.setText(winning[3][1]);
            mWinning3.setText(winning[3][2]);
            mWinning4.setText(winning[3][3]);
            mWinning5.setText(winning[3][4]);
        }else if (chose == 5){
            mWinning1.setText(winning[4][0]);
            mWinning2.setText(winning[4][1]);
            mWinning3.setText(winning[4][2]);
            mWinning4.setText(winning[4][3]);
            mWinning5.setText(winning[4][4]);
        }else if (chose == 6){
            mWinning1.setText(winning[5][0]);
            mWinning2.setText(winning[5][1]);
            mWinning3.setText(winning[5][2]);
            mWinning4.setText(winning[5][3]);
            mWinning5.setText(winning[5][4]);
        }
    }
    //確認發票傳到下頁
    public void check(View v){
        final EditText minput = findViewById(R.id.ET_input);
        Intent intent = new Intent(this, TRL_Redeem_Winning.class);
        Bundle bundle = new Bundle();
        bundle.putString("input", minput.getText().toString());
        bundle.putString("chose", String.valueOf(chose));
        bundle.putString("chosestring", chosestring);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    //回到月份選擇
    public void restart(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}