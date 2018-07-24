package com.guaju.rxmvpdemo.contract;

import android.support.v7.widget.RecyclerView;

import com.guaju.rxmvpdemo.base.BasePresenter;
import com.guaju.rxmvpdemo.base.BaseView;
import com.guaju.rxmvpdemo.bean.GoodsList;

/**
 * Created by guaju on 2018/7/23.
 */

public interface GoodsListContract {
    //契约接口
    interface View extends BaseView{
       //初始化recyclerview
      void initRecyclerView(RecyclerView rv);
      void onCompleted(GoodsList goodsList);

      void  refresh();
      
    }

    abstract class Presenter implements BasePresenter{
        //获取商品列表
        //方法的扩展
        public  abstract  void  getGoodsList();
    }


}
