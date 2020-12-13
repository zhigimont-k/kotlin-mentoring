package com.kotlin.mastermind

object MastermindGame {
    val CODE_LENGTH = 4
    val ALPHABET = 'A'..'F'
    var code = ""

    fun run(){
        code = CodeGenerator(CODE_LENGTH, ALPHABET).generate()
        //println("Code is: $code")
        println("Code length is ${CODE_LENGTH}, symbols are ${ALPHABET.toList()}\nPlease enter your guess:")
        do {
            var input = readLine()!!
            while(!AnswerChecker.isInputValid(input)){
                println("Please try again:")
                input = readLine()!!
            }
            var result = AnswerChecker.checkAnswer(input, code);
            if (result.first == CODE_LENGTH){
                break
            }
            println("You got ${result.second} letters right and were correct about ${result.first} positions of them! Please try again:")
            result = AnswerChecker.checkAnswer(input, code);
        } while(result.first != CODE_LENGTH)
        println("Congratulations, you won!")
    }
}