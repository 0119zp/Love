package com.zpan.love;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.zpan.love.view.LoveView;

public class MainActivity extends AppCompatActivity {

    private LoveView mLoveView;
    private TextView mLoveYes;
    private TextView mLoveNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mLoveView = findViewById(R.id.lv_zp_gk);
        mLoveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "缩放动画", Toast.LENGTH_SHORT).show();
            }
        });
        mLoveYes = findViewById(R.id.tv_login_dec_ok);
        mLoveYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "欢迎进入伊甸园", Toast.LENGTH_SHORT).show();
            }
        });
        mLoveNo = findViewById(R.id.tv_login_dec_no);
        mLoveNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "这么小都点的到", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
