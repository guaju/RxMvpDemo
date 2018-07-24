package com.guaju.rxmvpdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guaju.rxmvpdemo.R;
import com.guaju.rxmvpdemo.bean.Goods;

import java.util.ArrayList;

/**
 * Created by guaju on 2018/7/24.
 */

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.GoodsListViewHolder> {
    Context context;
    ArrayList<Goods> list;


    public GoodsListAdapter(Context context, ArrayList<Goods> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GoodsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item2, null);
        return  new GoodsListViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsListViewHolder holder, int position) {
        holder.setContent(list.get(position));
    }

     public  class GoodsListViewHolder extends RecyclerView.ViewHolder {
        TextView tv;


        public GoodsListViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
        public void setContent(Goods goods){
             tv.setText(goods.getName());
        }


    }

}
