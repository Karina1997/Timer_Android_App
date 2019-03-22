package com.example.myapplication.impl

import android.os.CountDownTimer
import com.example.myapplication.StateChanger
import com.example.myapplication.activities.CounterActivity.Companion.SECOND
import com.example.myapplication.numberConverter.Converter

class CountDownTimerImpl(
    millisInFuture: Long,
    countDownInterval: Long,
    val timeConst: Long,
    val converter: Converter,
    val stateChanger: StateChanger
) :
    CountDownTimer(millisInFuture, countDownInterval) {

    var timerState: Long = 0

    override fun onTick(millisUntilFinished: Long) {
        timerState = timeConst - millisUntilFinished
        stateChanger.changeOnTickState(converter.convert(((timerState) / SECOND).toInt()))
    }

    override fun onFinish() {
        timerState = 0
        stateChanger.changeFinishState()
    }

}