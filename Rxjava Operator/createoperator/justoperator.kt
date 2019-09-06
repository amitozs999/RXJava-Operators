package com.example.rxjavaoperators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class JustOperator : AppCompatActivity() {

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_just_operator)
        val observable = Observable.just(5,6,7,8)
        
        disposable = observable.subscribe { 
            Log.d(TAG, it.toString())
        }
        
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
    
}