package com.guaju.rxmvpdemo.view.activity.goodslist;

import android.support.v7.widget.RecyclerView;

import com.guaju.rxmvpdemo.R;
import com.guaju.rxmvpdemo.base.BaseActivity;

public class GoodsListActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void initData() {
        //获取数据
    }

    @Override
    protected void initView() {
      recyclerView= findViewById(R.id.rv);
    }

    @Override
    public int provideView() {
        return R.layout.activity_main;
    }
}
