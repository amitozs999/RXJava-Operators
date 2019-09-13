package com.example.rxjavaoperators

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {
 
  private var TAG = "MainActivity"
 
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
 
      button.setOnClickListener { startRStream() }
 
  }
 
  private fun startRStream() {
 
 
      val myObservable = getObservable()
 
      val myObserver = getObserver()
 
      myObservable
              .subscribe(myObserver)
  }
 
  private fun getObserver(): Observer<String> {
      return object : Observer<String> {
          override fun onSubscribe(d: Disposable) {
          }
 
          override fun onNext(s: String) {
              Log.d(TAG, "onNext: $s")
          }
 
 
          override fun onError(e: Throwable) {
              Log.e(TAG, "onError: " + e.message)
          }
 
          override fun onComplete() {
              Log.d(TAG, "onComplete")
          }
      }
  }
 
 
  private fun getObservable(): Observable<String> {
      return Observable.just("1", "2", "3", "4", "5")
  }
}