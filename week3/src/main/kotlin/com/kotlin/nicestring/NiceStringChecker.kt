package com.kotlin.nicestring

fun String.isNice(): Boolean {
    val result = listOf(!isBuBaBe(), hasThreeVowels(), hasDoubleLetters())
    return result.count { it } >= 2
}

fun String.isBuBaBe(): Boolean{
    return Regex("(ba)|(bu)|(be)") in this
}

fun String.hasThreeVowels(): Boolean{
    return "aeiou".sumBy { char -> count { it == char } } == 3
}

fun String.hasDoubleLetters(): Boolean{
    return (1 until length).any { this[it] == this[it-1] }
}

class NiceStringChecker {
    fun run(){
        println("Please enter a string to check:")
        var input = readLine()!!
        println("This string is ${if (input.isNice()) "" else "not "}nice")
    }
}