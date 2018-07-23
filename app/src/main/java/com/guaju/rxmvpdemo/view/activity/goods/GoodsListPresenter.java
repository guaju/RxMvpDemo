package com.guaju.rxmvpdemo.view.activity.goods;

import com.guaju.rxmvpdemo.contract.GoodsListContract;
import com.guaju.rxmvpdemo.engine.GoodsEngine;

/**
 * Created by guaju on 2018/7/23.
 */

public class GoodsListPresenter extends GoodsListContract.Presenter {
     GoodsListContract.View v;

    private GoodsEngine goodsEngine;

    public GoodsListPresenter(GoodsListContract.View v) {
        super(v);
    }

    @Override
    public void getGoodsList() {
        //获取商品列表      需要去操作model了
        goodsEngine = new GoodsEngine();
        goodsEngine.GoodsList("goodsapp", "index_nowsell", new GoodsEngine.OnRequestCompleted() {
            @Override
            public void onError() {

            }

            @Override
            public void onOver() {

            }

            @Override
            public void onCompleted(Object o) {

            }
        });

    }
}
