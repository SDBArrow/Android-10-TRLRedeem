package com.example.android_10_trlredeem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static int choseint = 0;
    static String chosestring = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //各期發票按鈕
    public void click0102(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        chosestring = "2018 01,02月發票";
        choseint = 1;
        mchose.setText("選定："+chosestring);
    }
    public void click0304(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        chosestring = "2018 03,04月發票";
        choseint = 2;
        mchose.setText("選定："+chosestring);
    }
    public void click0506(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        chosestring = "2018 05,06月發票";
        choseint = 3;
        mchose.setText("選定："+chosestring);
    }
    public void click0708(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        chosestring = "2018 07,08月發票";
        choseint = 4;
        mchose.setText("選定："+chosestring);
    }
    public void click0910(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        chosestring = "2018 09,10月發票";
        choseint = 5;
        mchose.setText("選定："+chosestring);
    }
    public void click1112(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        chosestring = "2018 11,12月發票";
        choseint = 6;
        mchose.setText("選定："+chosestring);
    }
    //確認傳值到下頁
    public void check(View v){
        Intent intent = new Intent(this, TRL_Redeem_numbers.class);
        Bundle bundle = new Bundle();
        bundle.putString("chosestring", chosestring);
        bundle.putString("choseint",String.valueOf(choseint));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}