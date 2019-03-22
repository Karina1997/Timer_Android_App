package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.impl.CountDownTimerImpl
import com.example.myapplication.impl.MainActivityStateChangerImpl
import com.example.myapplication.numberConverter.Converter


class MainActivity : AppCompatActivity() {

    lateinit var countDownTimer: CountDownTimerImpl
    var timerState: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerState = savedInstanceState?.getLong("timerState") ?: timerState
        val intent = Intent(this@MainActivity, CounterActivity::class.java)

        countDownTimer = CountDownTimerImpl(
            MILLISTILLFINISH - timerState, CounterActivity.SECOND,
            MILLISTILLFINISH, Converter(),
            MainActivityStateChangerImpl(intent, this)
        )
        countDownTimer.start()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putLong("timerState", countDownTimer.timerState)
    }

    override fun onStop() {
        super.onStop()
        countDownTimer.cancel()
    }

    companion object {
        const val MILLISTILLFINISH: Long = 2000
    }
}
