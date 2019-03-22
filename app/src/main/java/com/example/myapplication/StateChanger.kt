package com.example.myapplication

interface StateChanger {
    fun changeOnTickState(value: String)
    fun changeFinishState()
}