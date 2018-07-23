package com.guaju.rxmvpdemo.httpservice;

import com.guaju.rxmvpdemo.bean.GoodsList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by guaju on 2018/7/23.
 */

public interface FarmerService {
//    String GOODS_LIST = BASE_URL + "index.php?controller=goodsapp&action=index_nowsell";
    //获取现货列表
    @GET("index.php")
    Observable<GoodsList> goodsList(@Query("controller") String contr, @Query("action") String action);
}

