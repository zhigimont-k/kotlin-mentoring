package com.kotlin.nicestring

fun String.isNice() = listOf(!isBuBaBe(), countVowels() >= 3, hasDoubleLetters()).count { it } >= 2

fun String.isBuBaBe() = Regex("(ba)|(bu)|(be)") in this

fun String.countVowels() = "aeiou".sumBy { char -> count { it == char } }

fun String.hasDoubleLetters() = (1 until length).any { this[it] == this[it-1] }

fun main(){
    while(true){
        println("Please enter a string to check:")
        var input = readLine()!!
        println("This string is ${if (input.isNice()) "" else "not "}nice")
    }
}