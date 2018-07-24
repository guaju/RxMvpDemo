package com.guaju.rxmvpdemo.view.activity.goodslist;

import com.guaju.rxmvpdemo.bean.GoodsList;
import com.guaju.rxmvpdemo.contract.GoodsListContract;
import com.guaju.rxmvpdemo.engine.GoodsEngine;

/**
 * Created by guaju on 2018/7/23.
 */

public class GoodsListPresenter extends GoodsListContract.Presenter {
    GoodsListContract.View v;

    private GoodsEngine goodsEngine;

    public GoodsListPresenter(GoodsListContract.View v) {
       this.v=v;
    }

    @Override
    public void getGoodsList() {
        //获取商品列表      需要去操作model了
        goodsEngine = new GoodsEngine();
        goodsEngine.GoodsList("goodsapp", "index_nowsell", new GoodsEngine.OnRequestCompleted<GoodsList>() {
                    @Override
                    public void onError() {
                        v.onError();
                    }


                    @Override
                    public void onCompleted(GoodsList goodsList) {
                        v.onCompleted(goodsList);
                    }
                }
        );
    }

    @Override
    public void initData() {

    }
}
