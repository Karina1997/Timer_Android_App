package com.example.myapplication

import com.example.myapplication.numberConverter.Converter
import org.junit.Assert
import org.junit.Test

class ConverterTest {
    @Test
    fun converter_isCorrect() {
        val c = Converter()
        c.convert(123)
        Assert.assertEquals("сто двадцать три", c.convert(123))
        Assert.assertEquals("двести пятнадцать", c.convert(215))
        Assert.assertEquals("сто пять", c.convert(105))
        Assert.assertEquals("пять", c.convert(5))
        Assert.assertEquals("тысяча", c.convert(1000))
    }
}