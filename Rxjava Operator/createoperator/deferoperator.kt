package com.example.rxjavaoperators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

private const val TAG = "DeferOperator"

class DeferOperatorActivity : AppCompatActivity() {

    private lateinit var disposable1 :Disposable
    private lateinit var disposable2 :Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defer_operator)

        val testClass = TestClass()
        val observable = testClass.strObservable()
        val deferObservable = testClass.deferObservable()
        testClass.str = "World"
       disposable1 = observable.subscribe {
            Log.d(TAG, it) 
        }
        observable.subscribe()

        disposable2 =deferObservable.subscribe {
            Log.d(TAG, it) 
        }
    }

    override fun onDestroy() {
        disposable1.dispose() 
        disposable2.dispose()
        super.onDestroy()
    }
}

class TestClass {

    var str: String? = "Hello"
    fun strObservable() : Observable<String> {
        return Observable.just(str)
    }


    fun deferObservable() : Observable<String> {
        return Observable.defer {
            Observable.just(str)
        }
    }

}