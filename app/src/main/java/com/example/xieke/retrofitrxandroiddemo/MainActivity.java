package com.example.xieke.retrofitrxandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitFactory.getRetrofitInterfaceInstance().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GsonBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GsonBean gsonBean) {
                        if (gsonBean.resultcode == 200){
                            Log.d("美元实时转换价：", gsonBean.result.get(0).data1.bankConversionPri);
                        }else {
                            Log.d("error", "error");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
