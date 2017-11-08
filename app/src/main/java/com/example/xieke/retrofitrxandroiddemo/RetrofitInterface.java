package com.example.xieke.retrofitrxandroiddemo;

import com.google.gson.Gson;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Xieke on 2017/11/8.
 */

public interface RetrofitInterface {
    @GET("rmbquot?key=a9839662355a6dcdf470d5ba9ecff9ed")
    Observable<GsonBean> getData();
}
