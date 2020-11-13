package com.example.android_10_trlredeem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TRL_Redeem_Winning extends AppCompatActivity {
    static String Input = "";
    static int Chose = 0;
    static  String Chosestring = "";
    //個月中獎號碼
    String[][] winning={{"00106725","90819218","13440631","26650552","09775722","809","264"},
            {"03802602","00708299","33877270","21772506","61786409","136","022"},
            {"46356460","56337787","93339845","83390355","80431063","984","240"},
            {"45698621","19614436","96182420","47464012","62781818","928","899"},
            {"41482012","58837976","20379435","47430762","36193504","693","043","425"},
            {"59647042","01260528","01616970","69921388","53451508","710","585","633"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_r_l__redeem__winning);
        TV_show();
    }
    private void TV_show(){
        final TextView mWinning = findViewById(R.id.TV_Winning);
        //接收上頁傳值
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            Chose = Integer.parseInt(bundle.getString("chose"))-1;
            Input = bundle.getString("input");
            Chosestring = bundle.getString("chosestring");
        }
        //判斷中獎
        if(Integer.parseInt(Input)==Integer.parseInt(winning[Chose][0])){
            mWinning.setText("中獎金額：1000萬元");
        }else if (Integer.parseInt(Input)==Integer.parseInt(winning[Chose][1])){
            mWinning.setText("中獎金額：200萬元");
        }else if (Integer.parseInt(Input)==Integer.parseInt(winning[Chose][2]) || Integer.parseInt(Input)==Integer.parseInt(winning[Chose][3]) || Integer.parseInt(Input)==Integer.parseInt(winning[Chose][4])){
            mWinning.setText("中獎金額：20萬元");
        }else if (Integer.parseInt(Input.substring(1))==Integer.parseInt(winning[Chose][2].substring(1)) || Integer.parseInt(Input.substring(1))==Integer.parseInt(winning[Chose][3].substring(1)) || Integer.parseInt(Input.substring(1))==Integer.parseInt(winning[Chose][4].substring(1))) {
            mWinning.setText("中獎金額：4萬元");
        }else if (Integer.parseInt(Input.substring(2))==Integer.parseInt(winning[Chose][2].substring(2)) || Integer.parseInt(Input.substring(2))==Integer.parseInt(winning[Chose][3].substring(2)) || Integer.parseInt(Input.substring(2))==Integer.parseInt(winning[Chose][4].substring(2))) {
            mWinning.setText("中獎金額：1萬元");
        }else if (Integer.parseInt(Input.substring(3))==Integer.parseInt(winning[Chose][2].substring(3)) || Integer.parseInt(Input.substring(3))==Integer.parseInt(winning[Chose][3].substring(3)) || Integer.parseInt(Input.substring(3))==Integer.parseInt(winning[Chose][4].substring(3))) {
            mWinning.setText("中獎金額：4千元");
        }else if (Integer.parseInt(Input.substring(4))==Integer.parseInt(winning[Chose][2].substring(4)) || Integer.parseInt(Input.substring(4))==Integer.parseInt(winning[Chose][3].substring(4)) || Integer.parseInt(Input.substring(4))==Integer.parseInt(winning[Chose][4].substring(4))) {
            mWinning.setText("中獎金額：1千元");
        }else if (Integer.parseInt(Input.substring(5))==Integer.parseInt(winning[Chose][2].substring(5)) || Integer.parseInt(Input.substring(5))==Integer.parseInt(winning[Chose][3].substring(5)) || Integer.parseInt(Input.substring(5))==Integer.parseInt(winning[Chose][4].substring(5))) {
            mWinning.setText("中獎金額：2百元");
        }else{
            mWinning.setText("再接再厲!");
            for(int i = 0 ; i < winning[Chose].length-5; i++){
                if(Integer.parseInt(Input.substring(5))==Integer.parseInt(winning[Chose][i+5])){
                    mWinning.setText("中獎金額：2百元");
                    break;
                }
            }
        }
    }
    //跳頁到輸入號碼並回傳月份
    public void reinput(View v){
        Intent intent = new Intent(this, TRL_Redeem_numbers.class);
        Bundle bundle = new Bundle();
        bundle.putString("chosestring", Chosestring);
        bundle.putString("choseint",String.valueOf(Chose+1));
        intent.putExtras(bundle);
        startActivity(intent);
    }
    //跳頁到輸入月份
    public void restart(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}