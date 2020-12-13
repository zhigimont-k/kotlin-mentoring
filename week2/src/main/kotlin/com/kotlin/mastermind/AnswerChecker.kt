package com.kotlin.mastermind

object AnswerChecker {
    fun checkAnswer(answer : String, code : String) : Pair<Int, Int>{
        var correctPositions = code.zip(answer).count{it.first == it.second}
        var correctLetters = MastermindGame.ALPHABET.sumBy { char -> Math.min(code.count { it == char }, answer.count { it == char }) }
        return Pair(correctPositions, correctLetters)
    }

    fun isInputValid(answer: String) : Boolean{
        var result = true;
        if (answer.length != MastermindGame.CODE_LENGTH) {
            println("Answer length should be ${MastermindGame.CODE_LENGTH}")
            result = false
        }
        if (!answer.all {it in MastermindGame.ALPHABET }) {
            println("Answer should contain only symbols ${MastermindGame.ALPHABET.toList()}")
            result = false
        }
        return result
    }
}