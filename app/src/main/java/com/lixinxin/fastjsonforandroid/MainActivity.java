package com.lixinxin.fastjsonforandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lixinxin.fastjsonforandroid.bean.User;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn1;
    private Button btn2;
    private Button btn3;

    private User user1;
    private User user2;


    private List<User> lists;
    private List<User> lists2;


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
        btn3 = (Button) findViewById(R.id.btn3);
    }

    private void initData() {
        user1 = new User("lixinxin", true, 25);


        lists = new ArrayList<>();
        lists2 = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            user1 = new User("lxx" + i, true, 10 + i);
            lists.add(user1);
        }


        MarqueeView marqueeView = (MarqueeView) findViewById(R.id.marqueeView);
        MarqueeView marqueeView2 = (MarqueeView) findViewById(R.id.marqueeView2);
        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是李鑫鑫。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：lixinxinlove");
        marqueeView.startWithList(info);
        String notice = "心中有阳光，脚底有力量！心中有阳光，脚底有力量！心中有阳光，脚底有力量！";
        marqueeView2.startWithText(notice);

    }

    private void initEvent() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
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
            case R.id.btn3:
                jSONArrayToLists();
                break;

        }

    }

    private void jSONArrayToLists() {

        String s = JSON.toJSONString(lists);
        Log.e("lxx", s);


        lists2 = JSON.parseObject(s, new TypeReference<List<User>>() {});


        Log.e("lxx", lists2.size() + "-------------------");


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
