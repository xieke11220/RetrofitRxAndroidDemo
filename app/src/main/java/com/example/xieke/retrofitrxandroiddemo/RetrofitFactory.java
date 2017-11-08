package com.example.xieke.retrofitrxandroiddemo;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Xieke on 2017/11/8.
 */

public class RetrofitFactory {

    private static final String BASE_URL = "http://web.juhe.cn:8080/finance/exchange/";

    //接口实例
    private static RetrofitInterface retrofitInterface = new Retrofit.Builder() //retrofit
            .baseUrl(BASE_URL)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create())
            // 添加Retrofit到RxJava2的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetrofitInterface.class);

    //调用取得RetrofitInterface实例
    //当调用getRetrofitInterfaceInstance()静态方法时，会触发上面retrofitInterface静态变量的生成。
    public static RetrofitInterface getRetrofitInterfaceInstance(){
        return retrofitInterface;
    }


}
