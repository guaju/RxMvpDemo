package com.guaju.rxmvpdemo.base;

/**
 * Created by guaju on 2018/7/23.
 * 定义公共的视图展示清空
 */

public interface BaseView {
    void onEmpty();//当加载数据为空的时候
    void onError();  //加载错误的时候

}
