package com.example.myapplication.numberConverter

class Converter {
    val numbersMap = hashMapOf(
        1 to "один",
        2 to "два",
        3 to "три",
        4 to "четыре",
        5 to "пять",
        6 to "шесть",
        7 to "семь",
        8 to "восемь",
        9 to "девять",
        10 to "десять",
        11 to "одинадцать",
        12 to "двенадцать",
        13 to "тринадцать",
        14 to "четырнадцать",
        15 to "пятнадцать",
        16 to "шестнадцать",
        17 to "семнадцать",
        18 to "восемнадцать",
        19 to "девятнадцать",
        20 to "двадцать",
        30 to "тридцать",
        40 to "сорок",
        50 to "пятьдесят",
        60 to "шестьдесят",
        70 to "семьдесят",
        80 to "восемьдесят",
        90 to "девяносто",
        100 to "сто",
        200 to "двести",
        300 to "триста",
        400 to "четыреста",
        500 to "пятьсот",
        600 to "шестьсот",
        700 to "семьсот",
        800 to "восемьсот",
        900 to "девятьсот",
        1000 to "тысяча"
    )

    fun convert(x: Int): String {
        var stringBuffer = ""
        var i = 0
        var newX = x
        if ((10 < x % 100) && (x % 100 < 20)) {
            stringBuffer = numbersMap[x % 100] ?: ""
            i = 2
            newX = x / 100
        }

        while (i < x.toString().length) {
            val h = newX % 10 * Math.pow(10.toDouble(), i.toDouble())
            val add = numbersMap[h.toInt()] ?: ""
            if (add != "")
                if (stringBuffer != "")
                    stringBuffer = "$add $stringBuffer"
                else
                    stringBuffer = add
            i++
            newX /= 10
        }
        return stringBuffer
    }
}