package com.ibareq.rxjavatasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ibareq.rxjavatasks.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
    }

    private fun initObservers() {
        //TODO: uncomment any line to check its result

//        RXJavaTasks.task1().observeOn(AndroidSchedulers.mainThread()).subscribe(::updateText).addTo(compositeDisposable)
//        RXJavaTasks.task2().observeOn(AndroidSchedulers.mainThread()).subscribe(::updateText).addTo(compositeDisposable)
//        RXJavaTasks.task3().observeOn(AndroidSchedulers.mainThread()).subscribe(::updateText).addTo(compositeDisposable)
//        RXJavaTasks.task4().observeOn(AndroidSchedulers.mainThread()).subscribe(::updateText).addTo(compositeDisposable)
        RXJavaTasks.task5().observeOn(AndroidSchedulers.mainThread()).subscribe(::updateText).addTo(compositeDisposable)

    }

    private fun updateText(newValue: Any){
        binding.labelRxData.text = newValue.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}