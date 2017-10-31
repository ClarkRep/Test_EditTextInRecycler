package com.example.zhaodanyang.testedittextinrecyclerview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        BaseFragmentAdapter baseFragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(baseFragmentAdapter);


        baseFragmentAdapter.bindData(true, Arrays.asList(
                new TaskDetailFragment(),
                new TaskCheckItemFragment(),
                new TaskDetailFragment()

        ));
    }
}
