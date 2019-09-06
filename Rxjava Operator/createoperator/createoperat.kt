package com.example.rxjavaoperators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

private const val TAG = "CreateOperator"

class CreateOperatorActivity : AppCompatActivity() {
    private val numList = listOf(5, 6, 7, 8, 9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_operator)
        val observable = initializeObservable()
        val observer = initializeObserver()
        observable.subscribe(observer)
    }

    private fun initializeObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                Log.d(TAG, t.toString())
            }

            override fun onError(e: Throwable) {

            }
        }
    }

    private fun initializeObservable(): Observable<Int> {

        return Observable.create {
            for (i in numList)
                it.onNext(i)
            it.onComplete()
        }
    }
} 
