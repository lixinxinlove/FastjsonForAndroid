package com.lixinxin.fastjsonforandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.lixinxin.fastjsonforandroid.bean.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn1;
    private Button btn2;

    private User user1;
    private User user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();


    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
    }

    private void initData() {
        user1 = new User("lixinxin", true, 25);


    }

    private void initEvent() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn1:
                objToString();
                break;
            case R.id.btn2:
                jsonToObj();
                break;

        }

    }

    String jsonString;

    public void objToString() {
        jsonString = JSON.toJSONString(user1);
        Log.e("lxx", jsonString);
    }

    public void jsonToObj() {
        // user1 = new User("lxx", false, 18);
        //   String jsonString = JSON.toJSONString(user1);

        User user = JSON.parseObject(jsonString, User.class);

        Log.e("lxx", user.toString());
    }

}
