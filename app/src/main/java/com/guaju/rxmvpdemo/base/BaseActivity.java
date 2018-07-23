package com.guaju.rxmvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by guaju on 2018/7/23.
 */

public abstract class BaseActivity  extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideView());
        initData();
        initView();
    }

    protected abstract void initData();

    protected abstract void initView();

    public abstract int provideView();
}
