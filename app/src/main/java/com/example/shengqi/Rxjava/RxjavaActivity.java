package com.example.shengqi.Rxjava;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shengqi.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxjavaActivity extends AppCompatActivity {
    private Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        mbtn = findViewById(R.id.rx_btn);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable<String> observable = getObservable();
                Observer<String> observer = getObserver();
                Observer<String> observer1 = getObserver();

                observable.subscribe(observer);
                observable.subscribe(observer1);
            }
        });
    }

    public Observable<String> getObservable(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("我在吃饭");
                e.onNext("我在洗碗");
                e.onComplete();
//                e.onError();
            }
        });
    }

    public Observer<String> getObserver(){
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("observer", "onSubscribe: ");
            }

            @Override
            public void onNext(String value) {
                Log.d("observer", "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("observer", "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d("observer", "onComplete: ");
            }
        };
    }

}