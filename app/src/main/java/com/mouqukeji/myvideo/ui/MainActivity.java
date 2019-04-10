package com.mouqukeji.myvideo.ui;


import android.os.Bundle;

import com.mouqukeji.myvideo.BR;
import com.mouqukeji.myvideo.R;
import com.mouqukeji.myvideo.databinding.ActivityMainBinding;
import com.mouqukeji.myvideo.viewmodel.MainViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class MainActivity extends BaseActivity <ActivityMainBinding,MainViewModel>{


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
