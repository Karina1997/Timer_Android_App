package com.example.myapplication.impl

import android.widget.TextView
import android.widget.ToggleButton
import com.example.myapplication.StateChanger

class CounterActivityStateChangerImpl(
    val textView: TextView,
    val button: ToggleButton
) : StateChanger {

    override fun changeOnTickState(value: String) {
        textView.text = value
    }

    override fun changeFinishState() {
        button.performClick()
        textView.text = ""
    }
}