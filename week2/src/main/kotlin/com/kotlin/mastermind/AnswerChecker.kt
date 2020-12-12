package com.kotlin.mastermind

object AnswerChecker {
    fun checkAnswer(answer : String) : Pair<Int, Int>{
        var correctPositions = MastermindGame.code.toCharArray().zip(answer.toCharArray()).count{it.first == it.second}
        var correctLetters = MastermindGame.code.toCharArray().intersect(answer.asIterable()).size
        return Pair(correctPositions, correctLetters)
    }

    fun isInputValid(answer: String) : Boolean{
        var result = true;
        if (answer.length != MastermindGame.code.length) {
            println("Answer size should be ${MastermindGame.code.length}")
            result = false
        }
        if (!answer.all {it in MastermindGame.ALPHABET }) {
            println("Answer should contain only symbols ${MastermindGame.ALPHABET.toList()}")
            result = false
        }
        return result
    }
}