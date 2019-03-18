package com.example.myapplication.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.CountDownTimerImpl
import com.example.myapplication.R
import com.example.myapplication.numberConverter.Converter

class CounterActivity : AppCompatActivity() {

    var timerState: Long = 0
    var timer: CountDownTimerImpl? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if ((savedInstanceState != null) && (savedInstanceState["timerState"] != null)) {
            timerState = savedInstanceState.getLong("timerState")
        }

        setContentView(R.layout.activity_counter)
        val button: ToggleButton = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView2)
        if (timerState != 0L) {
            textView.text = Converter().convert((timerState / 1000).toInt())
        }

        button.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                timer = CountDownTimerImpl(1000000 - timerState, 1000, textView, button)
                timer?.start()
            } else {
                timer?.cancel()
                timerState = timer?.timerState ?: 0L
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            outState.putLong("timerState", timer?.timerState ?: 0L)
        }
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()
    }
}