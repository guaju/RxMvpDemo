package com.guaju.rxmvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.guaju.rxmvpdemo.R;

/**
 * Created by guaju on 2018/7/23.
 *
 * 定义一些公共的视图及视图展示的实现
 */


public abstract class BaseActivity  extends Activity implements BaseView{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provideView();
        //实例化presenter
        initView();
        initPresenter();
        initData();

        //在onCreate中 只是初始化布局及控件id  并不会展示出布局
    }

    //让子类去在onCreate中去实例化presenter
    protected abstract void initPresenter();

    //初始化数据（目前的app大多数都是联网的 所以需要准备数据）
    protected abstract void initData();  //不要试图去更改view
    //初始化视图
    protected abstract void initView();
    //提供布局
    public abstract void provideView();

    @Override
    protected void onResume() {
        //该生命周期会真正的把布局渲染出来
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onEmpty() {
        //做数据为空的逻辑
        setContentView(R.layout.empty);
    }

    @Override
    public void onError() {
        setContentView(R.layout.error);
    }
}
