package com.guaju.rxmvpdemo.view.activity.goodslist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guaju.rxmvpdemo.R;
import com.guaju.rxmvpdemo.adapter.GoodsListAdapter;
import com.guaju.rxmvpdemo.base.BaseActivity;
import com.guaju.rxmvpdemo.bean.Goods;
import com.guaju.rxmvpdemo.bean.GoodsList;
import com.guaju.rxmvpdemo.contract.GoodsListContract;

import java.util.ArrayList;

import app.dinus.com.itemdecoration.LinearDividerItemDecoration;

public class GoodsListActivity extends BaseActivity implements GoodsListContract.View {

    private RecyclerView recyclerView;
    //mvp 需要持有presenter
    GoodsListPresenter presenter;
    private GoodsListAdapter goodsListAdapter;
    private ArrayList<Goods> data;


    @Override
    protected void initPresenter() {
        presenter=new GoodsListPresenter(this);
    }

    @Override
    protected void initData() {
        //获取数据
        presenter.getGoodsList();

    }

    @Override
    protected void initView() {
      recyclerView= (RecyclerView) findViewById(R.id.rv);

    }

    @Override
    public void provideView() {
        setContentView(R.layout.activity_main);
    }


    @Override
    public void initRecyclerView(RecyclerView rv) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new LinearDividerItemDecoration(this,LinearDividerItemDecoration.LINEAR_DIVIDER_VERTICAL));
    }

    @Override
    public void onCompleted(GoodsList goodsList) {
        //当数据获取完之后
        data = (ArrayList<Goods>) goodsList.getData();
        setAdapter();

    }

    @Override
    public void refresh() {
        //需要再去获取数据
          presenter.getGoodsList();
    }




    //方法抽取
    public void  setAdapter(){
        if (goodsListAdapter!=null){
            goodsListAdapter.notifyDataSetChanged();
        }else{
            //设置recyclerview的布局样式
            initRecyclerView(recyclerView);
            goodsListAdapter = new GoodsListAdapter(this, data);
            recyclerView.setAdapter(goodsListAdapter);
        }
    }


}
