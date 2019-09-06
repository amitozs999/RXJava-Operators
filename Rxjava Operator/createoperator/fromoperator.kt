package com.example.rxjavaoperators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

private const val TAG = "FromOperator"

class FromOperatorActivity : AppCompatActivity() {

    private lateinit var disposable : Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_operator)

        val numList = arrayListOf(1,2,3,4,5)

        val numObservable = Observable.fromIterable(numList)

        disposable = numObservable.subscribe {
            Log.d(TAG, it.toString())
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
