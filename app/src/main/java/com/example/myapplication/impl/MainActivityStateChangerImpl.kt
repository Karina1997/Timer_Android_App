package com.example.myapplication.impl

import android.app.Activity
import android.content.Intent
import com.example.myapplication.StateChanger

class MainActivityStateChangerImpl(
    val intent: Intent,
    val activity: Activity
) : StateChanger {

    override fun changeOnTickState(value: String) {}

    override fun changeFinishState() {
        activity.startActivity(intent)
        activity.finish()
    }
}