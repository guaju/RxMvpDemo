package com.guaju.rxmvpdemo.engine;

import com.guaju.rxmvpdemo.bean.GoodsList;
import com.guaju.rxmvpdemo.httpservice.RetrofitUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by guaju on 2018/7/23.
 */

public class GoodsEngine {
    public  interface OnRequestCompleted<T>{
        void onError();  //获取数据为空
        void onCompleted(T t);
    }

    //获取列表的逻辑
    public void GoodsList(String controller, String action, final OnRequestCompleted<GoodsList>  onRequestCompleted){
        Observable<GoodsList> goodsListObservable = RetrofitUtils.getInstance().getBeanfarmerService().goodsList(controller, action);
        goodsListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GoodsList>() {
                    @Override
                    public void call(GoodsList goodsList) {
                        if (goodsList==null){
                            onRequestCompleted.onError();
                        }else
                            onRequestCompleted.onCompleted(goodsList);
                    }
                });

    }

}
