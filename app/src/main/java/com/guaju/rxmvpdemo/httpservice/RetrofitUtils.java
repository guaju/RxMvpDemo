package com.guaju.rxmvpdemo.httpservice;

import com.guaju.rxmvpdemo.api.FarmerApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by guaju on 2018/7/23.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final FarmerService beanfarmerService,stringFarmerService;

    private RetrofitUtils(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient build = builder.build();
        Retrofit beanRetrofit = new Retrofit.Builder()
                .baseUrl(FarmerApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        beanfarmerService = beanRetrofit.create(FarmerService.class);


        Retrofit stringRetrofit = new Retrofit.Builder()
                .baseUrl(FarmerApi.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        stringFarmerService = stringRetrofit.create(FarmerService.class);

    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public  FarmerService getBeanfarmerService(){
        return beanfarmerService;
    }
    public  FarmerService getStringfarmerService(){
        return stringFarmerService;
    }

}
