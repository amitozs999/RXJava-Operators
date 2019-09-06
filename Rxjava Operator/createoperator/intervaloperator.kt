package com.example.rxjavaoperators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

private const val TAG = "IntervalOperator"

class IntervalOperatorActivity : AppCompatActivity() {
    lateinit var disposable :Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interval_operator)

        val observable = Observable.interval(1, TimeUnit.SECONDS)

        disposable = observable.subscribe {
            Log.d(TAG, it.toString())
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}