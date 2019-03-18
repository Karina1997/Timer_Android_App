package com.example.myapplication

import android.os.CountDownTimer
import android.widget.TextView
import android.widget.ToggleButton
import com.example.myapplication.numberConverter.Converter

class CountDownTimerImpl(
    millisInFuture: Long,
    countDownInterval: Long,
    var textView: TextView,
    var button: ToggleButton
) :
    CountDownTimer(millisInFuture, countDownInterval) {

    val converter = Converter()
    var timerState: Long = 0

    override fun onTick(millisUntilFinished: Long) {
        timerState = 1000000 - millisUntilFinished
        textView.text = converter.convert(((timerState) / 1000).toInt())
    }

    override fun onFinish() {
        timerState = 0
        button.performClick()
        textView.text = ""
    }
}