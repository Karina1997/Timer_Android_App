package com.example.myapplication.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.impl.CountDownTimerImpl
import com.example.myapplication.impl.CounterActivityStateChangerImpl
import com.example.myapplication.numberConverter.Converter

class CounterActivity : AppCompatActivity() {

    var timerState: Long = 0
    var timer: CountDownTimerImpl? = null
    var btnState: Int = -1
    lateinit var button: ToggleButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        timerState = savedInstanceState?.getLong("timerState") ?: timerState
        button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView2)
        val converter = Converter()

        if (timerState != TIMERZEROVALUE) {
            textView.text = converter.convert((timerState / SECOND).toInt())
        }

        button.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                timer = CountDownTimerImpl(
                    MAXTIMERSTATE - timerState, SECOND, MAXTIMERSTATE,
                    converter, CounterActivityStateChangerImpl(textView, button)
                )
                timer?.start()
            } else {
                timer?.cancel()
                timerState = timer?.timerState ?: TIMERZEROVALUE
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putLong("timerState", timer?.timerState ?: TIMERZEROVALUE)
    }

    override fun onResume() {
        super.onResume()
        if (btnState != -1 && btnState != 0) button.performClick()
    }

    override fun onPause() {
        super.onPause()
        btnState = if (button.isChecked) 1 else 0
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()
    }

    companion object {
        const val TIMERZEROVALUE = 0L
        const val MAXTIMERSTATE: Long = 1000000
        const val SECOND: Long = 1000

    }
}